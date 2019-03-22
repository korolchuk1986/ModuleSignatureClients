package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CategorieDAO;
import fr.fiducial.signature.feature.clients.dao.DocumentDAO;
import fr.fiducial.signature.feature.clients.dao.PersonneDAO;
import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.Categorie;
import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import fr.fiducial.signature.feature.clients.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class DocumentServiceImpl implements DocumentService {
    private DocumentDAO documentDAO;
    private PersonneDAO personneDAO;
    private CategorieDAO categorieDAO;

    public DocumentServiceImpl(DocumentDAO documentDAO, PersonneDAO personneDAO, CategorieDAO categorieDAO) {
        this.documentDAO = documentDAO;
        this.personneDAO = personneDAO;
        this.categorieDAO = categorieDAO;
    }

    @Override
    public Path getPath(Long idClient, Long idDocument) throws ProblemeBaseException {
        Optional<Document> optionalDocument = documentDAO.findById(idDocument);
        if (!optionalDocument.isPresent())  {
            throw new ProblemeBaseException("Le document n'existe pas dans la base");
        }
        Document document = optionalDocument.get();
        if (document.getPersonne().getId().longValue() != idClient.longValue()) {
            throw new ProblemeBaseException("Le numéro de client contenu dans le document est différent du client donné");
        }
        return Paths.get(document.getLienVersContenu(), document.getLibelle() + "." + document.getTypeDoc());

    }

    @Override
    public List<DocumentDTO> getDocumentsByClient(Long idClient) {
        return documentDAO.findDocumentsByClient(idClient);
    }

    @Override
    public DocumentDTO uploadDocumentForClient(Long idClient, MultipartFile multipartFile, Path documentPath, String relativePath, String libelle, String typeDoc) throws IOException {
        // TODO mettre en transactionnel pour roll-back si pb
        DocumentDTO documentDTO = null;
        Optional<Personne> clientOptional = personneDAO.findById(idClient);
        if (clientOptional.isPresent()) {
            multipartFile.transferTo(documentPath.toFile());
            Document document = new Document(clientOptional.get(), libelle, typeDoc, relativePath);
            document = documentDAO.save(document);
            Long idCategorie = (document.getCategorie() == null ? null : document.getCategorie().getId());
            documentDTO = new DocumentDTO(document.getId(), idClient, document.getLibelle(), idCategorie,
                    document.getTypeDoc(), document.getDateEnregistrement());
        }
        return documentDTO;
    }

    @Override
    public DocumentDTO updateDocumentByClient(Long idClient, Long idDoc, DocumentDTO documentDTO, boolean isUpdateClient) throws ProblemeBaseException {
        // Seules 2 valeurs peuvent changer: la catégorie ou/et le libellé (dans ce cas, il faut aussi renommer le
        // fichier dans l'archive) donc à changer dans table

        Optional<Document> optionalDocument = documentDAO.findById(documentDTO.getId());
        if (! optionalDocument.isPresent()) {
            throw new ProblemeBaseException("Update document impossible car non présent dans base de données");
        }
        Document document = optionalDocument.get();

        boolean aModifier = false;
        String ancienLibelle = null;

        if (document.getPersonne().getId().longValue() != documentDTO.getIdClient().longValue()) { // vérif peut-être inutile
            throw new ProblemeBaseException("Update document impossible car le numéro du document n'est pas le même");
        }

        // si le libellé change
        if (!document.getLibelle().equals(documentDTO.getLibelle())) {
            ancienLibelle = document.getLibelle();
            document.setLibelle(documentDTO.getLibelle());
            aModifier = true;
        }

        // Si la catégorie n'était pas encore définie ou si elle change de valeur
        if ((documentDTO.getIdCategorie() != null)  && (document.getCategorie() == null ||
                document.getCategorie().getId().longValue() != documentDTO.getIdCategorie().longValue())) {
            Optional<Categorie> optionalCategorie = categorieDAO.findById(documentDTO.getIdCategorie());
            if (!optionalCategorie.isPresent()) {
                throw new ProblemeBaseException("Update document impossible car la categorie du document n'a pas été trouvée");
            }
            document.setCategorie(optionalCategorie.get());
            aModifier = true;
        }

        // on renomme le fichier s'il y a besoin et on modifie la BDD
        if (aModifier) {
            if (ancienLibelle != null) { // il faut renommer le fichier
                renommerFichier(ancienLibelle, document);
            }
            documentDAO.save(document);
            if (!isUpdateClient) { // juste l'update du libellé/catégorie du document pas de la fiche totale du client d'où mise à jour date enregistrement fiche
                changerDateEnregistrementFicheClient(document.getPersonne().getId());
            }
        }
        Long idCategorie = (document.getCategorie() == null ? null: document.getCategorie().getId());
        return new DocumentDTO(document);
    }

    @Override
    public void deleteDocument(Long idClient, Long idDocument) throws ProblemeBaseException {
        //TODO mettre transactionnel pour rollback
        Optional<Document> optionalDocument = documentDAO.findById(idDocument);
        if (!optionalDocument.isPresent()) {
            throw new ProblemeBaseException("Suppression du document impossible car il n'est pas dans la base de données");
        }
        Document document = optionalDocument.get();
        // on détruit le fichier dans l'archive
        Path path = Paths.get(document.getLienVersContenu(), document.getLibelle() + "." + document.getTypeDoc());
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ProblemeBaseException("Suppression du document physique impossible car il n'est pas dans les archives");
        }
        // on détruit dans la base
        documentDAO.delete(document);
        changerDateEnregistrementFicheClient(idClient);
    }

    private void renommerFichier(String ancienLibelle, Document doc) throws ProblemeBaseException {
        Path source = Paths.get(doc.getLienVersContenu(), ancienLibelle + "." + doc.getTypeDoc());
        Path destination = Paths.get(doc.getLienVersContenu(), doc.getLibelle() + "." + doc.getTypeDoc());
        try {
            Files.move(source, destination, REPLACE_EXISTING);
        } catch (IOException e) {
            throw new ProblemeBaseException("Impossible de renommer le fichier physique dans l'archive (il est peut-être ouvert?)");
        }
    }
    private void changerDateEnregistrementFicheClient(Long idClient) {
        Optional<Personne> optionalPersonne = personneDAO.findById(idClient);
        if (optionalPersonne.isPresent()) { // le cas où il n'est pas présent ne devrait pas arriver normalement
            Personne personne = optionalPersonne.get();
            java.sql.Date aujourdhui = new java.sql.Date(Instant.now().toEpochMilli()); //java.sql.Date.valueOf(LocalDate.now());
            if (!aujourdhui.equals(personne.getDateModifFiche())) {
                personne.setDateModifFiche(aujourdhui);
                personneDAO.save(personne);
            }
        }
    }
}

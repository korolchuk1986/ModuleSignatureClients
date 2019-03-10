package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CategorieDAO;
import fr.fiducial.signature.feature.clients.dao.DocumentDAO;
import fr.fiducial.signature.feature.clients.dao.PersonneDAO;
import fr.fiducial.signature.feature.clients.model.Categorie;
import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import fr.fiducial.signature.feature.clients.service.DocumentService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public Document get(Long id) {
        return null;
    }

    @Override
    public List<DocumentDTO> getDocumentsByClient(Long idClient) {
        return documentDAO.findDocumentsByClient(idClient);
    }

    @Override
    public DocumentDTO uploadDocumentForClient(Long idClient, MultipartFile multipartFile, Path documentPath, String relativePath, String libelle, String typeDoc) throws IOException {
        // TODO mettre en transactionel pour roll-back si pb
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
    public boolean updateDocumentByClient(Long idClient, Long idDoc, DocumentDTO documentDTO) {
        Optional<Document> optionalDocument = documentDAO.findById(idDoc);
        boolean aModifier = false;
        String ancienLibelle = null;

        // TODO mettre en transactionel pour roll-back si pb
        if (! optionalDocument.isPresent()) {
            return false;
        }
        Document doc = optionalDocument.get();
        if (idClient != documentDTO.getIdClient()) { // vérif peut-être inutile
            return false;
        }
        if (!doc.getLibelle().equals(documentDTO.getLibelle())) {
            ancienLibelle = doc.getLibelle();
            doc.setLibelle(documentDTO.getLibelle());
            aModifier = true;
        }

        if (doc.getCategorie() == null ||
                doc.getCategorie().getId().longValue() != documentDTO.getIdCategorie().longValue()) { // bien laisser longValue() car bug si equals ???
            Optional<Categorie> optionalCategorie = categorieDAO.findById(documentDTO.getIdCategorie());
            if (!optionalCategorie.isPresent()) {
                return false;
            }
            doc.setCategorie(optionalCategorie.get());
            aModifier = true;
        }

        if (aModifier) {
            if (ancienLibelle != null) { // il faut renommer le fichier
                try {
                    renommerFichier(ancienLibelle, doc);
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            documentDAO.save(doc);
            changerDateEnregistrementFicheClient(idClient);
        }

        return true;
    }

    private void renommerFichier(String ancienLibelle, Document doc) throws IOException {
        Path source = Paths.get(doc.getLienVersContenu(), ancienLibelle + "." + doc.getTypeDoc());
        Path destination = Paths.get(doc.getLienVersContenu(), doc.getLibelle() + "." + doc.getTypeDoc());
        Files.move(source, destination, REPLACE_EXISTING);
    }
    private void changerDateEnregistrementFicheClient(Long idClient) {
        Optional<Personne> optionalPersonne = personneDAO.findById(idClient);
        if (optionalPersonne.isPresent()) { // le cas où il n'est pas présent ne devrait pas arriver normalement
            Personne personne = optionalPersonne.get();
            java.sql.Date aujourdhui = java.sql.Date.valueOf(LocalDate.now());
            if (!aujourdhui.equals(personne.getDateModifFiche())) {
                personne.setDateModifFiche(aujourdhui);
                personneDAO.save(personne);
            }
        }
    }
}

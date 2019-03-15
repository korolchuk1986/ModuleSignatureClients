package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.*;
import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.*;
import fr.fiducial.signature.feature.clients.model.dto.*;
import fr.fiducial.signature.feature.clients.service.DocumentService;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonneServiceImpl implements PersonneService {
    private PersonneDAO personneDAO;
    private CapaciteDAO capaciteDAO;
    private CiviliteDAO civiliteDAO;
    private StatutDAO statutDAO;
    private TypeMaritalDAO typeMaritalDAO;
    private PaysDAO paysDAO;
    private VilleDAO villeDAO;
    private DocumentDAO documentDAO;
    private HistoriqueDAO historiqueDAO;
    private CategorieDAO categorieDAO;
    private AdresseDAO adresseDAO;
    private DecesDAO decesDAO;
    private DocumentService documentService;

    public PersonneServiceImpl(PersonneDAO personneDAO, CapaciteDAO capaciteDAO, CiviliteDAO civiliteDAO,
                               StatutDAO statutDAO, TypeMaritalDAO typeMaritalDAO, PaysDAO paysDAO,
                               VilleDAO villeDAO, DocumentDAO documentDAO,
                               HistoriqueDAO historiqueDAO, CategorieDAO categorieDAO, AdresseDAO adresseDAO,
                               DecesDAO decesDAO, DocumentService documentService) {
        this.historiqueDAO = historiqueDAO;
        this.statutDAO = statutDAO;
        this.personneDAO = personneDAO;
        this.civiliteDAO = civiliteDAO;
        this.villeDAO = villeDAO;
        this.paysDAO = paysDAO;
        this.capaciteDAO = capaciteDAO;
        this.typeMaritalDAO = typeMaritalDAO;
        this.documentDAO = documentDAO;
        this.categorieDAO = categorieDAO;
        this.adresseDAO = adresseDAO;
        this.decesDAO = decesDAO;
        this.documentService = documentService;
    }

    public List<ListePersonneDTO> getClients() {
        return personneDAO.findClients();
    }

    @Override
    public ClientInfoDTO getClientInfo(Long id) throws ProblemeBaseException {
        Optional<Personne> optionalClient = personneDAO.findById(id);
        if (!optionalClient.isPresent()) {
            throw new ProblemeBaseException("La personne " + id + " recherchée n'existe pas");
        }
        Personne client = optionalClient.get();
        Personne conjoint = client.getConjoint();
        return createClientInfoDTO(client, conjoint);
    }

    @Override
    public InfoFormulaireDTO getInfoFormulaire() {
        InfoFormulaireDTO infoFormulaireDTO = new InfoFormulaireDTO();
        infoFormulaireDTO.setCapacites(capaciteDAO.findAll());
        infoFormulaireDTO.setCivilites(civiliteDAO.findAll());
        infoFormulaireDTO.setStatuts(statutDAO.findAll());
        infoFormulaireDTO.setTypeMarital(typeMaritalDAO.findAll());
        infoFormulaireDTO.setPays(paysDAO.findAll());
        infoFormulaireDTO.setVilles(villeDAO.findAll());
        infoFormulaireDTO.setCategories(categorieDAO.findAll());
        return infoFormulaireDTO;
    }

    @Override
    public ClientInfoDTO createClient(ClientInfoDTO clientInfoDTO) throws ProblemeBaseException {
        Personne conjoint = null;

        // TODO à mettre en transactionnel pour rollback sinon inconsistances dans BDD
        Personne client = createPersonne(clientInfoDTO.getClient(), true);
        if (client == null) {
            throw new ProblemeBaseException("La création de ce client a échoué");
        }
        List<Adresse> adresses = clientInfoDTO.getClient().getAdresses();
        client.setAdresses(adresses);
        clientInfoDTO.getClient().setId(client.getId());

        if (clientInfoDTO.getConjoint() != null) {
            conjoint = createPersonne(clientInfoDTO.getConjoint(), false);
            if (conjoint == null) { // probleme création du conjoint
                throw new ProblemeBaseException("La création du conjoint a échoué");
            }
            clientInfoDTO.getConjoint().setId(conjoint.getId());
            ajouteConjoint(client, conjoint);
            ajouteConjoint(conjoint, client);
            adresses = clientInfoDTO.getConjoint().getAdresses();
            conjoint.setAdresses(adresses);
            conjoint = personneDAO.save(conjoint);
                // BDD devrait être construite differemment
                // de plus que ce passe-t-il si conjoint est aussi client???

        }
        // Il n'y a pas de document à la création
        client = personneDAO.save(client);

        return createClientInfoDTO(client, conjoint);
    }

    @Override
    public ClientInfoDTO updateClient(ClientInfoDTO clientInfoDTO, Long id) throws ProblemeBaseException {
        if (clientInfoDTO.getClient().getId() == null) {
            throw new ProblemeBaseException("Update impossible car le numéro du client est nul");
        }

        if (clientInfoDTO.getClient().getId().longValue() != id.longValue()) {
            throw new ProblemeBaseException("Update impossible car les numéros du client sont différents");
        }

        String pb = clientInfoDTO.verifieValidite(false);
        if (pb != null) { // il y a un problème à la validation des champs
            throw new ProblemeBaseException(pb);
        }
        Optional<Personne> optionalClient = personneDAO.findById(id);
        if (!optionalClient.isPresent()) {
            throw new ProblemeBaseException("Impossible de trouver le client n°" + id + " dans la base");
        }
        Personne client = optionalClient.get();
        Personne conjoint = null;

        updatePersonne(clientInfoDTO.getClient(), client);

        if (clientInfoDTO.getConjoint() != null) { // a un conjoint
            if (clientInfoDTO.getConjoint().getId() == null) { // le conjoint n'est pas encore dans la base
                // il faut le créer
                conjoint = createPersonne(clientInfoDTO.getConjoint(), false);
                if (conjoint == null) {
                    throw new ProblemeBaseException("Update impossible car la création du conjoint a échoué");
                }
                conjoint.setAdresses(clientInfoDTO.getConjoint().getAdresses());
                personneDAO.save(conjoint);
            } else {
                // juste une MAJ du conjoint
                Optional<Personne> optionalConjoint = personneDAO.findById(clientInfoDTO.getConjoint().getId());
                if (!optionalConjoint.isPresent()) {
                    throw new ProblemeBaseException("Update impossible car le conjoint n'est pas dans la base");
                }
                conjoint = optionalConjoint.get();
            }
            client.setConjoint(conjoint);
            conjoint.setConjoint(client);
        } else { // n'a pas de conjoint
            if (client.getConjoint() != null) { // le client avait un conjoint avant
                Personne conjointDAvant = client.getConjoint();
                conjointDAvant.setConjoint(null);
                personneDAO.save(conjointDAvant);
                client.setConjoint(null);
            }
        }
        updateDocuments(client, clientInfoDTO.getDocuments());
        personneDAO.save(client);
        return createClientInfoDTO(client, conjoint);
    }

    @Override
    public List<Adresse> getAdresses(Long idPersonne) {
        return personneDAO.findPersonneAdresses(idPersonne);
    }

    private ClientInfoDTO createClientInfoDTO(Personne client, Personne conjoint) {
        PersonneInfo clientInfo = new PersonneInfo(client);
        clientInfo.setAdresses(client.getAdresses());
        PersonneInfo conjointInfo = null;
        if (conjoint != null) {
            conjointInfo = new PersonneInfo(conjoint);
            conjointInfo.setAdresses(conjoint.getAdresses());
        }
        List<DocumentDTO> documentsDTO = documentDAO.findDocumentsByClient(client.getId());
        return new ClientInfoDTO(clientInfo, conjointInfo, documentsDTO,
                historiqueDAO.countEvtsByClient(client.getId()).longValue() > 0);
    }

    private void updateDocuments(Personne client, List<DocumentDTO> documentsDTO) throws ProblemeBaseException {
        // L'ajout et la destruction de document ne sont pas gérées là
        // on a les mêmes documents, juste les libellés et les catégories peuvent changer
        for (DocumentDTO documentDTO : documentsDTO) {
            documentService.updateDocumentByClient(client.getId(), documentDTO.getId(), documentDTO, true);
        }
    }

    private void updatePersonne(PersonneInfo personneInfo, Personne personne) throws ProblemeBaseException {
        Optional<Capacite> optionalCapacite = capaciteDAO.findById(personneInfo.getIdCapacite());
        if (!optionalCapacite.isPresent()) {
            throw new ProblemeBaseException("La capacite ne peut pas être nulle");
        }
        personne.setCapacite(optionalCapacite.get());

        Optional<Civilite> optionalCivilite = civiliteDAO.findById(personneInfo.getIdCivilite());
        if (!optionalCivilite.isPresent()) {
            throw new ProblemeBaseException("La civilité ne peut pas être nulle");
        }
        personne.setCivilite(optionalCivilite.get());

        Optional<Pays> optionalPaysNaissance = paysDAO.findById(personneInfo.getIdPaysNaissance());
        if (!optionalPaysNaissance.isPresent()) {
            throw new ProblemeBaseException("Le pays de naissance ne peut pas être nul");
        }
        personne.setPays(optionalPaysNaissance.get());

        Optional<Statut> optionalStatut = statutDAO.findById(personneInfo.getIdStatut());
        if (!optionalStatut.isPresent()) {
            throw new ProblemeBaseException("Le statut ne peut pas être nul");
        }
        personne.setStatut(optionalStatut.get());

        Optional<TypeMarital> optionalTypeMarital = typeMaritalDAO.findById(personneInfo.getIdTypeMarital());
        if (!optionalTypeMarital.isPresent()) {
            throw new ProblemeBaseException("Le type marital ne peut pas être nul");
        }
        personne.setTypeMarital(optionalTypeMarital.get());

        Optional<Ville> optionalVilleNaissance = villeDAO.findById(personneInfo.getIdVilleNaissance());
        if (!optionalVilleNaissance.isPresent()) {
            throw new ProblemeBaseException("La ville de naissance ne peut pas être nulle");
        }
        personne.setVilleNaissance(optionalVilleNaissance.get());

        personne.update(personneInfo);
    }

    private Personne createPersonne(PersonneInfo personneInfo, boolean estClient) throws ProblemeBaseException {
        Optional<Capacite> optionalCapacite = capaciteDAO.findById(personneInfo.getIdCapacite());
        if (!optionalCapacite.isPresent()) {
            throw new ProblemeBaseException("La capacite ne peut pas être nulle");
        }
        Capacite capacite = optionalCapacite.get();

        Optional<Civilite> optionalCivilite = civiliteDAO.findById(personneInfo.getIdCivilite());
        if (!optionalCivilite.isPresent()) {
            throw new ProblemeBaseException("La civilité ne peut pas être nulle");
        }
        Civilite civilite = optionalCivilite.get();

        Optional<Pays> optionalPaysNaissance = paysDAO.findById(personneInfo.getIdPaysNaissance());
        if (!optionalPaysNaissance.isPresent()) {
            throw new ProblemeBaseException("Le pays de naissance ne peut pas être nul");
        }
        Pays paysNaissance = optionalPaysNaissance.get();

        Optional<Statut> optionalStatut = statutDAO.findById(personneInfo.getIdStatut());
        if (!optionalStatut.isPresent()) {
            throw new ProblemeBaseException("Le statut ne peut pas être nul");
        }
        Statut statut = optionalStatut.get();

        Optional<TypeMarital> optionalTypeMarital = typeMaritalDAO.findById(personneInfo.getIdTypeMarital());
        if (!optionalTypeMarital.isPresent()) {
            throw new ProblemeBaseException("Le type marital ne peut pas être nul");
        }
        TypeMarital typeMarital = optionalTypeMarital.get();

        Optional<Ville> optionalVilleNaissance = villeDAO.findById(personneInfo.getIdVilleNaissance());
        if (!optionalVilleNaissance.isPresent()) {
            throw new ProblemeBaseException("La ville de naissance ne peut pas être nulle");
        }
        Ville villeNaissance = optionalVilleNaissance.get();

        personneInfo.setDateModif(java.sql.Date.valueOf(LocalDate.now()));

        Personne personne = new Personne(estClient, personneInfo.getNom(), personneInfo.getPrenoms(),
                personneInfo.getDateNaissance(), personneInfo.getVilleEtrangereNaissance(),
                personneInfo.getNationalite(), personneInfo.getProfession(), personneInfo.getNomUsuel(),
                personneInfo.getPrenomUsuel(), personneInfo.getEstPacse(), capacite,
                civilite, paysNaissance, statut, typeMarital, personneInfo.getDateLiaison(),
                villeNaissance, personneInfo.getClercReferent(),
                personneInfo.getNotaireReferent(), personneInfo.getDateModif(),
                personneInfo.getTelephonePerso(), personneInfo.getCommentTelephonePerso(),
                personneInfo.getTelephonePro(), personneInfo.getCommentTelephonePro(),
                personneInfo.getEmailPerso(), personneInfo.getCommentEmailPerso(),
                personneInfo.getEmailPro(), personneInfo.getCommentEmailPro(), personneInfo.getFax(),
                personneInfo.getCommentFax(), personneInfo.getSiteWeb(), personneInfo.getCommentSiteWeb(),
                personneInfo.getAdresses());
        personne = personneDAO.save(personne);
        if ((personne != null) && (personneInfo.getDateDeces() != null)) {
            Deces deces = ajouteDeces(personne, personneInfo);
            if (deces == null) {
                throw new ProblemeBaseException("Le décès n'a pas pu être sauvegardé");
            }
            personne.setDeces(deces);
        }
        return personne;
    }

    private void ajouteConjoint(Personne personne, Personne conjoint) {
        personne.setConjoint(conjoint);
        personneDAO.save(personne);
    }

    private Deces ajouteDeces(Personne personne, PersonneInfo personneInfo) throws ProblemeBaseException {
        Optional<Pays> optionalPays = paysDAO.findById(personneInfo.getIdPaysDeces());
        if (!optionalPays.isPresent())
            throw new ProblemeBaseException("Le pays de décès est obligatoire");
        Optional<Ville> optionalVille = villeDAO.findById(personneInfo.getIdVilleDeces());
        if (!optionalVille.isPresent())
            throw new ProblemeBaseException("La ville de décès est obligatoire");
        Deces deces = new Deces(personne.getId(), optionalPays.get(), personne,
                optionalVille.get(), personneInfo.getVilleEtrangereDeces(),
                personneInfo.getDateDeces(), personneInfo.getCommentDeces());
        return decesDAO.save(deces);
    }

    private Adresse ajouteAdresse(Personne client, Adresse adresse) {
        client.getAdresses().add(adresse);
        personneDAO.save(client);
        return adresse;
    }
}

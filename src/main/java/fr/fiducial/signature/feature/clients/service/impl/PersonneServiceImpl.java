package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.*;
import fr.fiducial.signature.feature.clients.model.*;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.PersonneInfo;
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

    public PersonneServiceImpl(PersonneDAO personneDAO, CapaciteDAO capaciteDAO, CiviliteDAO civiliteDAO,
                               StatutDAO statutDAO, TypeMaritalDAO typeMaritalDAO, PaysDAO paysDAO,
                               VilleDAO villeDAO, DocumentDAO documentDAO,
                               HistoriqueDAO historiqueDAO, CategorieDAO categorieDAO, AdresseDAO adresseDAO,
                               DecesDAO decesDAO) {
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
    }

    public List<ListePersonneDTO> getClients() {
        return personneDAO.findClients();
    }

    @Override
    public ClientInfoDTO getClientInfo(Long id) {
        ClientInfoDTO clientInfoDTO = null;
        Optional<PersonneInfo> optionalPersonneInfo = personneDAO.getClientInfo(id);
        if (optionalPersonneInfo.isPresent()) {
            clientInfoDTO = new ClientInfoDTO();
            PersonneInfo personneInfo = optionalPersonneInfo.get();
            clientInfoDTO.setClient(personneInfo);
            clientInfoDTO.getClient().setAdresses(personneDAO.findPersonneAdresses(id)); // %%%
            //clientInfoDTO.setAdresses(habitationDAO.getAdressesByClient(id));
            Long idConjoint = clientInfoDTO.getClient().getIdConjoint();
            if (idConjoint != null) {
                Optional<PersonneInfo> optionalConjointInfo = personneDAO.getClientInfo(idConjoint);
                if (optionalConjointInfo.isPresent()) {
                    clientInfoDTO.setConjoint(optionalConjointInfo.get());
                    clientInfoDTO.getConjoint().setAdresses(personneDAO.findPersonneAdresses(idConjoint)); // %%%
                }
            }
            clientInfoDTO.setDocuments(documentDAO.findDocumentsByClient(id));

            /*Optional<Deces> optionalDeces = decesDAO.findById(id);
            if (optionalDeces.isPresent()) {
                clientInfoDTO.setDeces(optionalDeces.get());
            }*/
            Integer evtsNb = historiqueDAO.countEvtsByClient(id);
            clientInfoDTO.setAHistorique(evtsNb > 0);

        }
        return clientInfoDTO;
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
    public ClientInfoDTO createClient(ClientInfoDTO clientInfoDTO) {
        // TODO à mettre en transactionnel pour rollback sinon inconsistances dans BDD
        Personne client = createPersonne(clientInfoDTO.getClient(), true);
        Personne conjoint = null;
        if (client == null) {
            return null;
        }
        clientInfoDTO.getClient().setId(client.getId());

        if (clientInfoDTO.getConjoint() != null) {
            conjoint = createPersonne(clientInfoDTO.getConjoint(), false);
            if (conjoint == null) { // probleme création du conjoint
                return null;
            }
            clientInfoDTO.getConjoint().setId(conjoint.getId());
            ajouteConjoint(client, conjoint);
            ajouteConjoint(conjoint, client);
            List<Adresse> adresses = clientInfoDTO.getConjoint().getAdresses();
            conjoint.setAdresses(adresses);
            personneDAO.save(client);
                // pas important. BDD devrait être construite differemment
                // de plus que ce passe-t-il si conjoint est aussi client???

        }
        List<Adresse> adresses = clientInfoDTO.getClient().getAdresses();
        client.setAdresses(adresses);
        personneDAO.save(client);
        return clientInfoDTO;
    }

    private Personne createPersonne(PersonneInfo personneInfo, boolean estClient) {
        Optional<Capacite> optionalCapacite = capaciteDAO.findById(personneInfo.getIdCapacite());
        if (!optionalCapacite.isPresent()) {
            return null;
        }
        Capacite capacite = optionalCapacite.get();

        Optional<Civilite> optionalCivilite = civiliteDAO.findById(personneInfo.getIdCivilite());
        if (!optionalCivilite.isPresent()) {
            return null;
        }
        Civilite civilite = optionalCivilite.get();

        Optional<Pays> optionalPaysNaissance = paysDAO.findById(personneInfo.getIdPaysNaissance());
        if (!optionalPaysNaissance.isPresent()) {
            return null;
        }
        Pays paysNaissance = optionalPaysNaissance.get();

        Optional<Statut> optionalStatut = statutDAO.findById(personneInfo.getIdStatut());
        if (!optionalStatut.isPresent()) {
            return null;
        }
        Statut statut = optionalStatut.get();

        Optional<TypeMarital> optionalTypeMarital = typeMaritalDAO.findById(personneInfo.getIdTypeMarital());
        if (!optionalTypeMarital.isPresent()) {
            return null;
        }
        TypeMarital typeMarital = optionalTypeMarital.get();

        Optional<Ville> optionalVilleNaissance = villeDAO.findById(personneInfo.getIdVilleNaissance());
        if (!optionalVilleNaissance.isPresent()) {
            return null;
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
                return null;
            }
            personne.setDeces(deces);
        }
        return personne;
    }

    private void ajouteConjoint(Personne personne, Personne conjoint) {
        personne.setConjoint(conjoint);
        personneDAO.save(personne);
    }

    private Deces ajouteDeces(Personne personne, PersonneInfo personneInfo) {
        Optional<Pays> optionalPays = paysDAO.findById(personneInfo.getIdPaysDeces());
        if (!optionalPays.isPresent())
            return null;
        Optional<Ville> optionalVille = villeDAO.findById(personneInfo.getIdVilleDeces());
        if (!optionalVille.isPresent())
            return null;
        Deces deces = new Deces(personne.getId(), optionalPays.get(), personne,
                optionalVille.get(), personneInfo.getVilleEtrangereDeces(),
                personneInfo.getDateDeces(), personneInfo.getCommentDeces());
        deces = decesDAO.save(deces);
        return deces;
    }

    private Adresse ajouteAdresse(Personne client, Adresse adresse) {
        client.getAdresses().add(adresse);
        personneDAO.save(client);
        return adresse;
    }
}

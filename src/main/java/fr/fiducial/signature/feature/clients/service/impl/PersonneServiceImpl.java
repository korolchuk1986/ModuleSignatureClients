package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.*;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Categorie;
import fr.fiducial.signature.feature.clients.model.Deces;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.PersonneInfo;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonneServiceImpl implements PersonneService {
    private PersonneDAO personneDAO;
    private CapaciteDAO capaciteDAO;
    private CiviliteDAO civiliteDAO;
    private StatutDAO statutDAO;
    private TypeMaritalDAO typeMaritalDAO;
    private PaysDAO paysDAO;
    private VilleDAO villeDAO;
    private HabitationDAO habitationDAO;
    private DocumentDAO documentDAO;
    private HistoriqueDAO historiqueDAO;
    private CategorieDAO categorieDAO;

    public PersonneServiceImpl(PersonneDAO personneDAO, CapaciteDAO capaciteDAO, CiviliteDAO civiliteDAO,
                               StatutDAO statutDAO, TypeMaritalDAO typeMaritalDAO, PaysDAO paysDAO,
                               VilleDAO villeDAO, HabitationDAO habitationDAO, DocumentDAO documentDAO,
                               HistoriqueDAO historiqueDAO, CategorieDAO categorieDAO) {
        this.historiqueDAO = historiqueDAO;
        this.statutDAO = statutDAO;
        this.personneDAO = personneDAO;
        this.civiliteDAO = civiliteDAO;
        this.villeDAO = villeDAO;
        this.paysDAO = paysDAO;
        this.capaciteDAO = capaciteDAO;
        this.typeMaritalDAO = typeMaritalDAO;
        this.documentDAO = documentDAO;
        this.habitationDAO = habitationDAO;
        this.categorieDAO = categorieDAO;
    }

    public List<ListePersonneDTO> getAll() {
        return personneDAO.findClients();
    }

    @Override
    public ClientInfoDTO getClientInfo(Long id) {
        ClientInfoDTO clientInfoDTO = null;
        Optional<PersonneInfo> optionalPersonneInfo = personneDAO.getClientInfo(id);
        if (optionalPersonneInfo.isPresent()) {
            clientInfoDTO = new ClientInfoDTO();
            clientInfoDTO.setClient(optionalPersonneInfo.get());
            clientInfoDTO.setAdresses(habitationDAO.getAdressesByClient(id));
            Long idConjoint = clientInfoDTO.getClient().getIdConjoint();
            Optional<PersonneInfo> optionalConjointInfo = personneDAO.getClientInfo(idConjoint);
            if (optionalConjointInfo.isPresent()) {
                clientInfoDTO.setConjoint(optionalConjointInfo.get());
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
    public Set<Adresse> getAdresses(Long idClient) {
        return habitationDAO.getAdressesByClient(idClient);
    }


}

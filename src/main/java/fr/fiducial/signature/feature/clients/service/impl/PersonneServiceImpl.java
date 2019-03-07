package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.*;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Deces;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    private PersonneDAO personneDAO;
    @Autowired
    private CapaciteDAO capaciteDAO;
    @Autowired
    private CiviliteDAO civiliteDAO;
    @Autowired
    private StatutDAO statutDAO;
    @Autowired
    private TypeMaritalDAO typeMaritalDAO;
    @Autowired
    private PaysDAO paysDAO;
    @Autowired
    private VilleDAO villeDAO;
    @Autowired
    private HabitationDAO habitationDAO;
    @Autowired
    private DecesDAO decesDAO;
    @Autowired
    private HistoriqueDAO historiqueDAO;

    public List<ListePersonneDTO> getAll() {
        return personneDAO.findClients();
    }

    @Override
    public ClientInfoDTO getClientInfo(Long id) {
        ClientInfoDTO clientInfoDTO = null;
        Optional<ClientInfoDTO> optionalClientInfoDTO = personneDAO.getClientInfo(id);
        if (optionalClientInfoDTO.isPresent()) {
            clientInfoDTO = optionalClientInfoDTO.get();
            clientInfoDTO.setAdresses(habitationDAO.getAdressesByClient(id));
            Optional<Deces> optionalDeces = decesDAO.findById(id);
            if (optionalDeces.isPresent()) {
                clientInfoDTO.setDeces(optionalDeces.get());
            }
            Integer evtsNb = historiqueDAO.countEvtsByClient(id);
            if (evtsNb > 0) {
                clientInfoDTO.setaHistorique(true);
            }
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
        return infoFormulaireDTO;
    }

    @Override
    public Set<Adresse> getAdresses(Long idClient) {
        return habitationDAO.getAdressesByClient(idClient);
    }
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.*;
import fr.fiducial.signature.feature.clients.model.Adresse;
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

    public List<ListePersonneDTO> getAll() {
        return personneDAO.findClients();
    }

    @Override
    public Optional<ClientInfoDTO> getClientInfo(Long id) {
        return personneDAO.getClientInfo(id);
    }

    @Override
    public InfoFormulaireDTO getInfoFormulaire() {
        InfoFormulaireDTO infoFormulaireDTO = new InfoFormulaireDTO();
        infoFormulaireDTO.setCapacites(capaciteDAO.findAll());
        infoFormulaireDTO.setCivilites(civiliteDAO.findAll());
        infoFormulaireDTO.setStatuts(statutDAO.findAll());
        infoFormulaireDTO.setTypeMarital(typeMaritalDAO.findAll());
        return infoFormulaireDTO;
    }
}

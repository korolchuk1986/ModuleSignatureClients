package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;

import java.util.List;

public interface PersonneService {
    List<ListePersonneDTO> getAll();
    InfoFormulaireDTO getInfoFormulaire();
    ClientInfoDTO getClientInfo(Long id);
    List<Adresse> getAdresses(Long id);
    ClientInfoDTO createClient(ClientInfoDTO clientInfoDTO);
    //TODO à compléter

}

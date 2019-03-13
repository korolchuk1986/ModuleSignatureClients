package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;

import java.util.List;

public interface PersonneService {
    List<ListePersonneDTO> getClients();
    InfoFormulaireDTO getInfoFormulaire();
    ClientInfoDTO getClientInfo(Long id);
    ClientInfoDTO createClient(ClientInfoDTO clientInfoDTO);

}

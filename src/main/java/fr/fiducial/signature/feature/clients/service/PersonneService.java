package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;

import java.util.List;
import java.util.Optional;

public interface PersonneService {
    List<ListePersonneDTO> getAll();
    InfoFormulaireDTO getInfoFormulaire();
    public Optional<ClientInfoDTO> getClientInfo(Long id);
    //TODO à compléter

}

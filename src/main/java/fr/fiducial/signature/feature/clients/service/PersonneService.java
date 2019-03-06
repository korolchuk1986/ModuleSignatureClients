package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface PersonneService {
    List<ListePersonneDTO> getAll();
    InfoFormulaireDTO getInfoFormulaire();
    ClientInfoDTO getClientInfo(Long id);
    Set<Adresse> getAdresses(Long id);
    //TODO à compléter

}

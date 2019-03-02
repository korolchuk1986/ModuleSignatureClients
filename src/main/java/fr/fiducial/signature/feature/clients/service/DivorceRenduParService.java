package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.DivorceRenduPar;
import java.util.Set;

public interface DivorceRenduParService {
    Set<DivorceRenduPar> getAll();
    DivorceRenduPar get(Long id);
}

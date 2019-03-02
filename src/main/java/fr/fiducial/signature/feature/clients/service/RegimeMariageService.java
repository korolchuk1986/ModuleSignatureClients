package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.RegimeMariage;

import java.util.Optional;

public interface RegimeMariageService {
    Optional<RegimeMariage> get(Long id);
    Iterable<RegimeMariage> getAll();
}

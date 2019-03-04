package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Civilite;

import java.util.Optional;

public interface CiviliteService {
    Optional<Civilite> get(Long id);
    Iterable<Civilite> getAll();
}

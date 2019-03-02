package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Capacite;

import java.util.Optional;

public interface CapaciteService {
    Optional<Capacite> get(Long id);
    Iterable<Capacite> getAll();
}

package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Statut;

import java.util.Optional;

public interface StatutService {
    Optional<Statut> get(Long id);
    Iterable<Statut> getAll();
}

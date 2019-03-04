package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.TypeEvenement;

import java.util.Optional;

public interface TypeEvenementService {
    Optional<TypeEvenement> get(Long id);
    Iterable<TypeEvenement> getAll();
}

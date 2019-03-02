package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.TypeMarital;

import java.util.Optional;

public interface TypeMaritalService {
    Optional<TypeMarital> get(Long id);
    Iterable<TypeMarital> getAll();
}

package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.TypePacs;

import java.util.Optional;

public interface TypePacsService {
    Optional<TypePacs> get(Long id);
    Iterable<TypePacs> getAll();
}

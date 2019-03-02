package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.LieuMariage;

import java.util.Optional;

public interface LieuMariageService {
    Optional<LieuMariage> get(Long id);
    Iterable<LieuMariage> getAll();
}

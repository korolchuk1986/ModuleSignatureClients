package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.CauseRupturePacs;

import java.util.Optional;

public interface CauseRupturePacsService {
    Optional<CauseRupturePacs> get(Long id);
    Iterable<CauseRupturePacs> getAll();
}

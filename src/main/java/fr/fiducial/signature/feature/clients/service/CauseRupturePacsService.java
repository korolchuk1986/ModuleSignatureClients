package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.CauseRupturePacs;

import java.util.Set;

public interface CauseRupturePacsService {
    CauseRupturePacs get(Long id);
    Set<CauseRupturePacs> getAll();
}

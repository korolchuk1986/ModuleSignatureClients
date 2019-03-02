package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Capacite;

import java.util.Set;

public interface CapaciteService {
    Capacite get(Long id);
    Set<Capacite> getAll();
}

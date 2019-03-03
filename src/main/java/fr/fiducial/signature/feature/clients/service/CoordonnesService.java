package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Coordonnees;

import java.util.Optional;

public interface CoordonnesService {
    Coordonnees create(Coordonnees coordonnees);
    Optional<Coordonnees> get(Long id);
    void update(Coordonnees coordonnees);
    void delete(Coordonnees coordonnees);
}

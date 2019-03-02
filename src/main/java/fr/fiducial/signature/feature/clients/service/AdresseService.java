package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;

import java.util.Optional;

public interface AdresseService {
    Adresse create(Adresse adresse);
    void delete(Adresse adresse);
    void update(Adresse adresse);
    Optional<Adresse> get(Long id);
}

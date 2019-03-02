package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;

public interface AdresseService {
    Adresse create(Adresse adresse);
    void delete(Adresse adresse);
    void update(Adresse adresse);
    Adresse get(Long id);
}

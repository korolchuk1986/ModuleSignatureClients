package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Categorie;

import java.util.Optional;

public interface CategorieService {
    Optional<Categorie> get(Long id);
    Iterable<Categorie> getAll();
}

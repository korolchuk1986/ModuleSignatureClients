package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Personne;

import java.util.Set;

public interface PersonneService {
    Iterable<Personne> getAll();
    Set<Adresse> getAdresses(long id);
    //TODO à compléter
}

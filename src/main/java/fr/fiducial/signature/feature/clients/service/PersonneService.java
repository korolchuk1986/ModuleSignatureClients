package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;

import java.util.List;
import java.util.Set;

public interface PersonneService {
    List<ListePersonneDTO> getAll();
    List<Personne> getByNomPrenoms(String nom, String prenoms);
    Set<Adresse> getAdresses(long id);
    //TODO à compléter

}

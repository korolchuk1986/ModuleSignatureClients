package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Ville;

import java.util.Set;

public interface VilleService {
    /*
    cette méthode est utile pour ajouter une ville étrangère. Les villes françaises sont censées toutes être
    répertoriées dans la table TOPAD
    */
    Ville create(Ville ville);
    Set<Ville> getVillesByCP(String cp);
    Set<Ville> getVillesByDebut(String debutNom);
    Ville getVilleByCPEtNom(String cp, String nom);
    Ville get(long id);
}
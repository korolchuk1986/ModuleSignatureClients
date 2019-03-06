package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;

import java.util.Set;

public interface HabitationService {
    Set<Adresse> getAdressesByClient(Long id);
    Habitation add(Habitation habitation);
}

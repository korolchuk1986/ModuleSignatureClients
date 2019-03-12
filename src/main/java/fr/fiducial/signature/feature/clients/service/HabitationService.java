package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;

import java.util.List;

public interface HabitationService {
    List<Adresse> getAdressesByClient(Long id);
    Habitation add(Habitation habitation);
}

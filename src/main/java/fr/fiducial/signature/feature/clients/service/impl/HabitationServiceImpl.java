package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;
import fr.fiducial.signature.feature.clients.service.HabitationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HabitationServiceImpl implements HabitationService {
    @Override
    public Set<Adresse> getAdressesByClient(Long id) {
        return null;
    }

    @Override
    public Habitation add(Habitation habitation) {
        return null;
    }
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.HabitationDAO;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;
import fr.fiducial.signature.feature.clients.service.HabitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HabitationServiceImpl implements HabitationService {
    @Autowired
    private HabitationDAO habitationDAO;

    @Override
    public Set<Adresse> getAdressesByClient(Long id) {
        Set<Adresse> adresses = habitationDAO.getAdressesByClient(id);
        return adresses;
    }

    @Override
    public Habitation add(Habitation habitation) {
        return null;
    }
}

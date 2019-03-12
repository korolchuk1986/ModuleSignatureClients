package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.HabitationDAO;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;
import fr.fiducial.signature.feature.clients.service.HabitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitationServiceImpl implements HabitationService {
    private HabitationDAO habitationDAO;

    public HabitationServiceImpl(HabitationDAO habitationDAO) {
        this.habitationDAO = habitationDAO;
    }

    @Override
    public List<Adresse> getAdressesByClient(Long id) {
        return habitationDAO.getAdressesByClient(id);
    }

    @Override
    public Habitation add(Habitation habitation) {
        return null;
    }
}

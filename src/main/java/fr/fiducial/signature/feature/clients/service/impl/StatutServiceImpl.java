package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.StatutDAO;
import fr.fiducial.signature.feature.clients.model.Statut;
import fr.fiducial.signature.feature.clients.service.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatutServiceImpl implements StatutService {
    @Autowired
    StatutDAO statutDAO;

    @Override
    public Optional<Statut> get(Long id) {
        return statutDAO.findById(id);
    }

    @Override
    public Iterable<Statut> getAll() {
        return statutDAO.findAll();
    }
}

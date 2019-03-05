package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.StatutDAO;
import fr.fiducial.signature.feature.clients.model.Statut;
import fr.fiducial.signature.feature.clients.service.StatutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StatutServiceImpl implements StatutService {
    @Autowired
    private StatutDAO statutDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<Statut> get(Long id) {
        return statutDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<Statut> getAll() {
        return statutDAO.findAll();
    }
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CapaciteDAO;
import fr.fiducial.signature.feature.clients.model.Capacite;
import fr.fiducial.signature.feature.clients.service.CapaciteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CapaciteServiceImpl implements CapaciteService {
    @Autowired
    private CapaciteDAO capaciteDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<Capacite> get(Long id) {
        return capaciteDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<Capacite> getAll() {
        return capaciteDAO.findAll();
    }
}

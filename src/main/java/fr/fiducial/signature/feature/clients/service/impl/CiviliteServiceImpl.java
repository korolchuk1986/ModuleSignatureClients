package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CiviliteDAO;
import fr.fiducial.signature.feature.clients.model.Civilite;
import fr.fiducial.signature.feature.clients.service.CiviliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CiviliteServiceImpl implements CiviliteService {
    @Autowired
    CiviliteDAO civiliteDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<Civilite> get(Long id) {
        return civiliteDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<Civilite> getAll() {
        return civiliteDAO.findAll();
    }
}

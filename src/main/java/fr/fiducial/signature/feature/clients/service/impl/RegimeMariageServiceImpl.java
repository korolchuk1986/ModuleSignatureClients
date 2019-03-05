package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.RegimeMariageDAO;
import fr.fiducial.signature.feature.clients.model.RegimeMariage;
import fr.fiducial.signature.feature.clients.service.RegimeMariageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RegimeMariageServiceImpl implements RegimeMariageService {
    @Autowired
    private RegimeMariageDAO regimeMariageDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<RegimeMariage> get(Long id) {
        return regimeMariageDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<RegimeMariage> getAll() {
        return regimeMariageDAO.findAll();
    }
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.DivorceRenduParDAO;
import fr.fiducial.signature.feature.clients.dao.PaysDAO;
import fr.fiducial.signature.feature.clients.model.DivorceRenduPar;
import fr.fiducial.signature.feature.clients.service.DivorceRenduParService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class DivorceRenduParServiceImpl implements DivorceRenduParService {
    @Autowired
    private DivorceRenduParDAO divorceRenduParDAO;

    @Override
    @Transactional(readOnly=true)
    public Set<DivorceRenduPar> getAll() {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public DivorceRenduPar get(Long id) {
        return null;
    }
}

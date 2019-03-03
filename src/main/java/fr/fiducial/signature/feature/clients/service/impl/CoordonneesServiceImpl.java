package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CoordonneesDAO;
import fr.fiducial.signature.feature.clients.model.Coordonnees;
import fr.fiducial.signature.feature.clients.service.CoordonnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CoordonneesServiceImpl implements CoordonnesService {
    @Autowired
    CoordonneesDAO coordonneesDAO;

    @Override
    public Coordonnees create(Coordonnees coordonnees) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Coordonnees> get(Long id) {
        return coordonneesDAO.findById(id);
    }

    @Override
    public void update(Coordonnees coordonnees) {

    }

    @Override
    public void delete(Coordonnees coordonnees) {

    }
}

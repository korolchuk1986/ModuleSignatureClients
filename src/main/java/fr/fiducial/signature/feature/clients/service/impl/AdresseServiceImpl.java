package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.AdresseDAO;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class AdresseServiceImpl implements AdresseService {
    @Autowired
    AdresseDAO adresseDAO;

    @Override
    public Adresse create(Adresse adresse) {
        //return adresseDAO.save(adresse);
        //TODO
        return null;
    }

    @Override
    public void delete(Adresse adresse) {
        //TODO
    }

    @Override
    public void update(Adresse adresse) {
        //TODO
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Adresse> get(Long id) {
        return adresseDAO.findById(id);
    }
}

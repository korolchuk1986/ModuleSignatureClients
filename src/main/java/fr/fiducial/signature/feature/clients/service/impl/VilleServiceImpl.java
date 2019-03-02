package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.VilleDAO;
import fr.fiducial.signature.feature.clients.model.Ville;
import fr.fiducial.signature.feature.clients.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class VilleServiceImpl implements VilleService {
    @Autowired
    VilleDAO vDao;

    @Override
    public Ville create(Ville ville) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Set<Ville> getVillesByCP(String cp) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Set<Ville> getVillesByDebut(String debutNom) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Ville getVilleByCPEtNom(String cp, String nom) {
        return null;
    }

    @Override
    @Transactional(readOnly=true)
    public Ville getVilleById(long id) {
        return null;
    }
}

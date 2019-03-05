package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.EvenementDAO;
import fr.fiducial.signature.feature.clients.model.Evenement;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementServiceImpl implements EvenementService {
    @Autowired
    private EvenementDAO evenementDAO;

    @Override
    public Evenement create(Evenement evenement) {
        //TODO
        return null;
    }

    @Override
    public Iterable<Evenement> getEvenementsByClient(Personne client) {
        //TODO
        return null;
    }
    //TODO à completer
}

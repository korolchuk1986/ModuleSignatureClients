package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.HistoriqueDAO;
import fr.fiducial.signature.feature.clients.model.Evenement;
import fr.fiducial.signature.feature.clients.model.Historique;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HistoriqueServiceImpl implements HistoriqueService {
    @Autowired
    HistoriqueDAO historiqueDAO;

    @Override
    public Historique add(Historique historique) {
        return  historiqueDAO.save(historique);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<Evenement> getEvenementsByClient(Personne personne) {
        return historiqueDAO.findEvenementsByClient(personne.getId());
    }

    @Override
    public void deleteHistoriqueMatrimonialByClient(Personne personne) {
        historiqueDAO.deleteHistoriqueMatrimonialByClient(personne.getId());
    }
}

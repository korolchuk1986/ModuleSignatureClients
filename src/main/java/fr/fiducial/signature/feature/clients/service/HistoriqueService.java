package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Evenement;
import fr.fiducial.signature.feature.clients.model.Historique;
import fr.fiducial.signature.feature.clients.model.Personne;

public interface HistoriqueService {
    Historique add(Historique historique);
    Iterable<Evenement> getEvenementsByClient(Personne personne);
    void deleteHistoriqueMatrimonialByClient(Personne personne);
    Integer countEvtsByClient(Long id_personne);
}

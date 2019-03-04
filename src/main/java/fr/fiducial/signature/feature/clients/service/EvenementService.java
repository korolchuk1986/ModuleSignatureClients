package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Evenement;
import fr.fiducial.signature.feature.clients.model.Personne;
import org.springframework.stereotype.Service;

@Service
public interface EvenementService {
    Evenement create(Evenement evenement);
    Iterable<Evenement> getEvenementsByClient(Personne client);
    //TODO à compléter
}

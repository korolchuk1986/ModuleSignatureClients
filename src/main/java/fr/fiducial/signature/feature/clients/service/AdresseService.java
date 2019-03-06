package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Adresse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AdresseService {
    Adresse create(Adresse adresse);
    void delete(Adresse adresse);
    void update(Adresse adresse);
    Optional<Adresse> get(Long id);
}

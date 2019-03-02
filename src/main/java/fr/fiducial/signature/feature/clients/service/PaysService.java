package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Pays;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface PaysService {
    Iterable<Pays> getAll();
    Optional<Pays> get(Long id);
    ResponseEntity<String> deletePays(String nom);
    Pays postPay(@RequestBody Pays pay);
}


package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Pays;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaysService {
    Iterable<Pays> getAll();
    ResponseEntity<String> deletePays(String nom);
    Pays postPay(@RequestBody Pays pay);
}


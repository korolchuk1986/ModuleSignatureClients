package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Coordonnees;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordonneesDAO extends CrudRepository<Coordonnees, Long> {
    // à voir si c'est Long ou Personne
}

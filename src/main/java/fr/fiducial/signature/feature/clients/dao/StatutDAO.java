package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Statut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDAO extends CrudRepository<Statut, Long> {
}

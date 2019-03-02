package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Capacite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaciteDAO extends CrudRepository<Capacite, Long> {

}

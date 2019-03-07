package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Deces;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DecesDAO extends CrudRepository<Deces, Long> {
}

package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.RegimeMariage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimeMariageDAO extends CrudRepository<RegimeMariage, Long> {
}

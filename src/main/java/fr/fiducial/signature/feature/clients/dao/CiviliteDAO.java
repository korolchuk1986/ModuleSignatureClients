package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Civilite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiviliteDAO extends CrudRepository<Civilite, Long> {
}

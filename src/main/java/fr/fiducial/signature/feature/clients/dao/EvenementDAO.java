package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Evenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.mapping.CrudMethodsSupportedHttpMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementDAO extends CrudRepository<Evenement, Long> {
}

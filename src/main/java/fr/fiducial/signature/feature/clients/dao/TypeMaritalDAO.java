package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.TypeMarital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMaritalDAO extends CrudRepository<TypeMarital, Long> {
}

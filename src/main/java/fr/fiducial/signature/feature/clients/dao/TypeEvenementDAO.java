package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.TypeEvenement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEvenementDAO extends CrudRepository<TypeEvenement, Long> {
}

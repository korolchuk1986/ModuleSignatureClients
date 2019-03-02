package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.TypePacs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePacsDAO extends CrudRepository<TypePacs, Long> {
}

package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentDAO extends CrudRepository<Document, Long> {
}

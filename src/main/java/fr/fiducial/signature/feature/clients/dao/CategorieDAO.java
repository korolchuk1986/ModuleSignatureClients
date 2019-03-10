package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDAO extends CrudRepository<Categorie, Long> {
}

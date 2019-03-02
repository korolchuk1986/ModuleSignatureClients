package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Ville;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleDAO extends CrudRepository<Ville, Long> {

}
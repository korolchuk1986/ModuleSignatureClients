package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseDAO extends CrudRepository<Adresse, Long> {

}
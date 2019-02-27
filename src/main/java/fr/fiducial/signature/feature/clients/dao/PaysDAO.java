package fr.fiducial.signature.feature.clients.dao;


import fr.fiducial.signature.feature.clients.model.Pays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface PaysDAO extends CrudRepository<Pays, Long> {
    @Transactional
    Long removeByNom(String nom);
}

package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Personne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneDAO extends CrudRepository<Personne, Long> {
    @Query("from Personne as p where p.estClient=true")
    Iterable<Personne> findClients();

    Iterable<Personne> findAllByEstClientTrue();


}

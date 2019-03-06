package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HabitationDAO extends CrudRepository<Habitation, Long> {
    @Query("select h.adresse " +
            "from Habitation as h " +
            "where h.personne.id=:idPersonne")
    Set<Adresse> getAdressesByClient(@Value("idPersonne") Long idPersonne);
}

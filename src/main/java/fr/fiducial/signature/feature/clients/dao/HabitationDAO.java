package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Habitation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitationDAO extends CrudRepository<Habitation, Long> {
}

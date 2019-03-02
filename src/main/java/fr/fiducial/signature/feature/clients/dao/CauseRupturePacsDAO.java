package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Capacite;
import fr.fiducial.signature.feature.clients.model.CauseRupturePacs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CauseRupturePacsDAO extends CrudRepository<CauseRupturePacs, Long> {
}

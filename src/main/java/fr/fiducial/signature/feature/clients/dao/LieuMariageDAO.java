package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.LieuMariage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuMariageDAO  extends CrudRepository<LieuMariage, Long> {
}

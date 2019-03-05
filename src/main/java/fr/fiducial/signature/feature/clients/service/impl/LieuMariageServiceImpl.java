package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.LieuMariageDAO;
import fr.fiducial.signature.feature.clients.model.LieuMariage;
import fr.fiducial.signature.feature.clients.service.LieuMariageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class LieuMariageServiceImpl implements LieuMariageService {
    @Autowired
    private LieuMariageDAO lieuMariageDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<LieuMariage> get(Long id) {
        return lieuMariageDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<LieuMariage> getAll() {
        return lieuMariageDAO.findAll();
    }
}

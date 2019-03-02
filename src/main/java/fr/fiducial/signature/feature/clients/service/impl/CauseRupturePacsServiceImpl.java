package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CauseRupturePacsDAO;
import fr.fiducial.signature.feature.clients.model.CauseRupturePacs;
import fr.fiducial.signature.feature.clients.service.CauseRupturePacsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
public class CauseRupturePacsServiceImpl implements CauseRupturePacsService {
    @Autowired
    private CauseRupturePacsDAO causeRupturePacsDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<CauseRupturePacs> get(Long id) {
        return causeRupturePacsDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<CauseRupturePacs> getAll() {
        return causeRupturePacsDAO.findAll();
    }
}

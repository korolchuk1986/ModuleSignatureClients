package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.TypePacsDAO;
import fr.fiducial.signature.feature.clients.model.TypePacs;
import fr.fiducial.signature.feature.clients.service.TypePacsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TypePacsServiceImpl implements TypePacsService {
    @Autowired
    private TypePacsDAO typePacsDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<TypePacs> get(Long id) {
        return typePacsDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<TypePacs> getAll() {
        return typePacsDAO.findAll();
    }
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.TypeMaritalDAO;
import fr.fiducial.signature.feature.clients.model.TypeMarital;
import fr.fiducial.signature.feature.clients.service.TypeMaritalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class TypeMaritalServiceImpl implements TypeMaritalService {
    @Autowired
    TypeMaritalDAO typeMaritalDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<TypeMarital> get(Long id) {
        return typeMaritalDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<TypeMarital> getAll() {
        return typeMaritalDAO.findAll();
    }
}

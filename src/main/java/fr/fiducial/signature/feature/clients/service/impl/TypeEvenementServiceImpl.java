package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.TypeEvenementDAO;
import fr.fiducial.signature.feature.clients.model.TypeEvenement;
import fr.fiducial.signature.feature.clients.service.TypeEvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TypeEvenementServiceImpl implements TypeEvenementService {
    @Autowired
    TypeEvenementDAO typeEvenementDAO;

    @Override
    @Transactional(readOnly=true)
    public Optional<TypeEvenement> get(Long id) {
        return typeEvenementDAO.findById(id);
    }

    @Override
    @Transactional(readOnly=true)
    public Iterable<TypeEvenement> getAll() {
        return typeEvenementDAO.findAll();
    }
}

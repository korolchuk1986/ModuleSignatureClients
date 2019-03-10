package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.CategorieDAO;
import fr.fiducial.signature.feature.clients.model.Categorie;
import fr.fiducial.signature.feature.clients.service.CategorieService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {
    private CategorieDAO categorieDAO;

    public CategorieServiceImpl(CategorieDAO categorieDAO) {
        this.categorieDAO = categorieDAO;
    }

    @Override
    public Optional<Categorie> get(Long id) {
        return categorieDAO.findById(id);
    }

    @Override
    public Iterable<Categorie> getAll() {
        return categorieDAO.findAll();
    }
}

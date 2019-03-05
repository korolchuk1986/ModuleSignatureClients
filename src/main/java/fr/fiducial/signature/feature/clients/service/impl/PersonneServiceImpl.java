package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.PersonneDAO;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    private PersonneDAO personneDAO;

    public List<ListePersonneDTO> getAll() {
        return personneDAO.findClients();
    }

    @Override
    public List<Personne> getByNomPrenoms(String nom, String prenoms) {
        return personneDAO.findByNomAndPrenomsAllIgnoreCase(nom, prenoms);
    }

    public Set<Adresse> getAdresses(long id) {
        return null;
    }

    //TODO à compléter
}

package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.PersonneDAO;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Service
public class PersonneServiceImpl implements PersonneService {
    @Autowired
    private PersonneDAO personneDAO;

    public Iterable<Personne> getAll() {
        return personneDAO.findClients();
    }

    public Set<Adresse> getAdresses(long id) {
        return null;
    }

    //TODO à compléter
}

package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.dao.PersonneDAO;
import fr.fiducial.signature.feature.clients.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "personne", produces = "application/json")
public class PersonneService {

    @Autowired
    private PersonneDAO personneDAO;

    @GetMapping("/clients")
    public Iterable<Personne> getAll() {
        return personneDAO.findClients();
    }


}

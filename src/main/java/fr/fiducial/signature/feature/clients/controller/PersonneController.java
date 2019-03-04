package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "personne", produces = "application/json")
public class PersonneController {
    @Autowired
    private PersonneService personneService;

    @GetMapping("/clients")
    public Iterable<Personne> getAll() {
        return personneService.getAll();
    }
}

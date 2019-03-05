package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "personne", produces = "application/json")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/clients")
    public List<ListePersonneDTO> getAll() {
        List<ListePersonneDTO>  listInfoPersonnes= personneService.getAll();
        return listInfoPersonnes;
    }

    @GetMapping("/{nom}/{prenom}")
    public List<Personne> getByNomPrenoms(@Param("nom") String nom, @Param("prenoms") String prenoms) {
        return personneService.getByNomPrenoms(nom, prenoms);
    }
}

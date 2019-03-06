package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Habitation;
import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.service.AdresseService;
import fr.fiducial.signature.feature.clients.service.HabitationService;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = "personne", produces = "application/json")
public class PersonneController {
    private final PersonneService personneService;
    private final HabitationService habitationService;

    public PersonneController(PersonneService personneService, HabitationService habitationService) {
        this.personneService = personneService;
        this.habitationService = habitationService;
    }

    @GetMapping("/clients")
    public List<ListePersonneDTO> getAll() {
        List<ListePersonneDTO>  listInfoPersonnes= personneService.getAll();
        return listInfoPersonnes;
    }

    @RequestMapping(value = "/client/{id}", method = GET)
    public ClientInfoDTO getClientInfo(@PathVariable("id") Long id) {
        return personneService.getClientInfo(id);
    }

    @RequestMapping(value = "/infoFormulaire", method = GET)
    public InfoFormulaireDTO getInfoFormulaire() {
        InfoFormulaireDTO infoFormulaire = personneService.getInfoFormulaire();
        return infoFormulaire;
    }

    @RequestMapping(value = "/adresses/{id}", method = GET)
    public Set<Adresse> getAdresse(@PathVariable("id") Long id) {
        return habitationService.getAdressesByClient(id);
    }
}

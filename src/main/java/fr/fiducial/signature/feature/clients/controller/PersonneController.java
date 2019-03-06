package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

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

    @RequestMapping(value = "/client/{id}", method = GET)
    public Optional<ClientInfoDTO> getClientInfo(@PathVariable("id") Long id) {
        Optional<ClientInfoDTO> personneInfo = personneService.getClientInfo(id);
        return personneInfo;
    }

    @RequestMapping(value = "/infoFormulaire", method = GET)
    public InfoFormulaireDTO getInfoFormulaire() {
        InfoFormulaireDTO infoFormulaire = personneService.getInfoFormulaire();
        return infoFormulaire;
    }
}

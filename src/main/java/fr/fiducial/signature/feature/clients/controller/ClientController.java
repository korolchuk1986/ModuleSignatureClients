package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.dto.InfoFormulaireDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "signature", produces = "application/json")
public class ClientController {
    private final PersonneService personneService;

    public ClientController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/clients")
    public @ResponseBody ResponseEntity<?> getClients() {

        return new ResponseEntity<>(personneService.getClients(), HttpStatus.OK);
    }

    @RequestMapping(value = "/client/{id}", method = GET)
    public @ResponseBody ResponseEntity<?> getClientInfo(@PathVariable("id") Long id) {
        try {
            return new ResponseEntity<>(personneService.getClientInfo(id), HttpStatus.OK);
        } catch (ProblemeBaseException e) {
            System.out.println("Probleme  " + e.getMessage());
            return new ResponseEntity<>("Get info client n°" + id + " " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/client/{id}/update", method = PUT)
    public @ResponseBody ResponseEntity<?> updateClient(@RequestBody ClientInfoDTO clientDTO, @PathVariable("id") Long id) {
        System.out.println("update client " + clientDTO);

        try {
             // quelques vérifications si valeurs des champs sont correctes
            String pb = clientDTO.verifieValidite(false);
            if (pb != null) {
                return new ResponseEntity<>("Update client n°" + id + " " + pb, HttpStatus.BAD_REQUEST);
            }
            ClientInfoDTO clientInfoDTO2 = personneService.updateClient(clientDTO, id);
            return new ResponseEntity<>(clientInfoDTO2, HttpStatus.OK);
        } catch (ProblemeBaseException e) {
                System.out.println("Probleme  " + e.getMessage());
                return new ResponseEntity<>("Update client n°" + id + " " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/client/add", method = POST)
    public @ResponseBody ResponseEntity<?> createClient(@RequestBody ClientInfoDTO clientDTO) {
        System.out.println("creation client" + clientDTO);

        try {
            // quelques vérifications si valeurs des champs sont correctes
            String pb = clientDTO.verifieValidite(true);
            if (pb != null) {
                return new ResponseEntity<>(pb, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(personneService.createClient(clientDTO), HttpStatus.OK);
        } catch (ProblemeBaseException e) {
            System.out.println("Probleme  " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/infoFormulaire", method = GET)
    public @ResponseBody ResponseEntity<?>  getInfoFormulaire() {
        return new ResponseEntity<>(personneService.getInfoFormulaire(), HttpStatus.OK);
    }

    @RequestMapping(value = "/client/{id}/adresses", method = GET)
    public @ResponseBody ResponseEntity<?>  getAdresses(@PathVariable("id") Long id) {
        // pour tests uniquement
        return new ResponseEntity<>(personneService.getAdresses(id), HttpStatus.OK);
    }
}

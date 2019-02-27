package fr.fiducial.signature.feature.clients.service;


import fr.fiducial.signature.feature.clients.dao.PaysDAO;
import fr.fiducial.signature.feature.clients.model.Pays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "pays", produces = "application/json")
public class PaysService {

    @Autowired
    private PaysDAO paysDAO;

    @GetMapping("getAll")
    public Iterable<Pays> getAll() {
        return paysDAO.findAll();
    }

    @DeleteMapping("/delete/{nom}")
    public ResponseEntity<String> deletePays(@PathVariable("nom") String nom) {
        System.out.println("Delete pay");
        paysDAO.removeByNom(nom);
        return new ResponseEntity<>("Pay deleted!", HttpStatus.OK);
    }
}

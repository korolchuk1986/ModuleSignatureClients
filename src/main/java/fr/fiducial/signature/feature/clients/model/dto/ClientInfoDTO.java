package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    private PersonneInfo client = null;
    private PersonneInfo conjoint = null;
    //private List<Adresse> adresses;
    private List<DocumentDTO> documents;
    private Boolean aHistorique = false;

    public String verifieValidite(boolean clientEnCreation) { // retourne null si ok, sinon cause pb
        String pb = client.verifieValidite();
        if (pb != null) {
            return pb;
        }
        if (conjoint != null) {
            pb = conjoint.verifieValidite();
            if (pb != null) {
                return pb;
            }
        }
        if (client.getAdresses() != null) {
            for (Adresse adresse : client.getAdresses()) {
                if ((adresse.getVille() == null) || (adresse.getPays() == null) || (adresse.getNomVoie() == null)) { // attention test faux car pas pris en compte villeEtrangere (cf BDD)
                    return "Ville, Pays, et nom de la voie de l'adresse ne peuvent pas être vides";
                }
            }
        }
        /*if ((conjoint != null) && (conjoint.getAdresses() != null)) {
            for (Adresse adresse : conjoint.getAdresses()) {
                if ((adresse.getVille() == null) || (adresse.getPays() == null)) { // attention test faux car pas pris en compte villeEtrangere (cf BDD)
                    return false;
                }
            }
        }*/
         // impossible d'uploader des documents tant que le client n'est pas
         // créé car sinon pb avec BDD et document pas mis au bon endroit dans archive
        if (clientEnCreation && (documents.size() != 0)) {
            return "Impossible d'ajouter des documents à un client en création (car manque l'upload)";
        }
        return null;
    }
}

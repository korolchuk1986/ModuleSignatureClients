package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Deces;
import fr.fiducial.signature.feature.clients.model.Pays;
import fr.fiducial.signature.feature.clients.model.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    private PersonneInfo client = null;
    private PersonneInfo conjoint = null;
    private Set<Adresse> adresses;
    private Boolean aHistorique = false;
    private Date dateLiaison = null;
}

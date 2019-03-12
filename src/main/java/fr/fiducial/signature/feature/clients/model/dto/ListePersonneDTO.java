package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.model.Adresse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListePersonneDTO {
    private String civilite;
    private String nom;
    private String prenoms;
    private Integer num;
    private String ordreVoie;
    private String typeVoie;
    private String nomVoie;
    private String cp;
    private String nomVille;
    private Date dateModif;
    private Long id;
    private Adresse adresse;

}

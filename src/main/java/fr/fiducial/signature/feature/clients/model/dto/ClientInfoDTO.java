package fr.fiducial.signature.feature.clients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    //private String civilite;
    private String nom;
    private String prenoms;
    private Long id;
    //private String capacite;
    /*private String typeMarital;
    private Boolean estPacse;
    */

   /* private String nomConjoint;
    private String prenomsConjoint;
    private Date dateLiaison;*/
    /*private String telephonePerso;
    private String emailPerso;
    private String clercReferent;
    private String notaireReferent;
    private Date dateModif;*/
}

package fr.fiducial.signature.feature.clients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    private Long id;
    private String civilite;
    private String nom;
    private String prenoms;
    private String capacite;
    private String statut;
    private String typeMarital;
    private Boolean estPacse;
    private Date dateModif;
    private String telephonePerso;
    private String emailPerso;
    private String clercReferent;
    private String notaireReferent;
    private String commentEmailPerso;
    private String commentTelephonePerso;
    private String emailPro;
    private String commentEmailPro;
    private String telephonePro;
    private String commentTelephonePro;
    private String fax;
    private String commentFax;
    private String siteWeb;
    private String commentSiteWeb;
    private Date dateNaissance;
    private String nationalite;
    private String nomUsuel;
    private String prenomUsuel;

    /*
   private String nomConjoint;
    private String prenomsConjoint;
    private Date dateLiaison;
    private String telephonePerso;*/
    /*private String emailPerso;
    private String clercReferent;
    private String notaireReferent;*/
}

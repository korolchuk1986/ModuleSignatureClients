package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.model.Deces;
import fr.fiducial.signature.feature.clients.model.Pays;
import fr.fiducial.signature.feature.clients.model.Ville;
import lombok.Data;

import java.util.Date;

@Data
public abstract class PersonneInfo {
    protected long id;
    protected String civilite;
    protected String nom;
    protected String prenoms;
    protected String statut;
    protected Date dateNaissance;
    protected String nationalite;
    protected String nomUsuel;
    protected String prenomUsuel;
    protected String capacite;
    protected String profession;
    protected Pays paysNaissance;
    protected Ville villeNaissance;
    protected String villeEtrangereNaissance;
    protected Date dateDeces = null;
    protected Ville villeDeces = null;
    protected String villeEtrangereDeces = null;
    protected Pays paysDeces = null;
    protected String commentDeces = null;
    protected String telephonePerso;
    protected String emailPerso;
    protected String clercReferent;
    protected String notaireReferent;
    protected String commentEmailPerso;
    protected String commentTelephonePerso;
    protected String emailPro;
    protected String commentEmailPro;
    protected String telephonePro;
    protected String commentTelephonePro;
    protected String fax;
    protected String commentFax;
    protected String siteWeb;
    protected String commentSiteWeb;

    public void setDeces(Deces deces) {
        this.commentDeces = deces.getCommentaire();
        this.dateDeces = deces.getDateDeces();
        this.paysDeces = deces.getPays();
        this.villeDeces = deces.getVille();
        this.paysDeces = deces.getPays();
    }

}

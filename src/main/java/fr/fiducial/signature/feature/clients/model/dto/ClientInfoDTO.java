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
    private Date dateDeces = null;
    private Ville villeDeces = null;
    private String villeEtrangereDeces = null;
    private Pays paysDeces = null;
    private String commentDeces = null;
    private Set<Adresse> adresses;
    private Boolean aHistorique = false;

    // ne pas effacer (pas générable par lombok)
    public ClientInfoDTO(Long id, String civilite, String nom, String prenoms, String capacite, String statut, String typeMarital,
                         Boolean estPacse, Date dateModif, String telephonePerso, String emailPerso, String clercReferent,
                         String notaireReferent, String commentEmailPerso, String commentTelephonePerso, String emailPro,
                         String commentEmailPro, String telephonePro, String commentTelephonePro, String fax, String commentFax,
                         String siteWeb, String commentSiteWeb, Date dateNaissance, String nationalite, String nomUsuel, String prenomUsuel) {
        this.id = id;
        this.civilite = civilite;
        this.nom = nom;
        this.prenoms = prenoms;
        this.capacite = capacite;
        this.statut = statut;
        this.typeMarital = typeMarital;
        this.estPacse = estPacse;
        this.dateModif = dateModif;
        this.telephonePerso = telephonePerso;
        this.emailPerso = emailPerso;
        this.clercReferent = clercReferent;
        this.notaireReferent = notaireReferent;
        this.commentEmailPerso = commentEmailPerso;
        this.commentTelephonePerso = commentTelephonePerso;
        this.emailPro = emailPro;
        this.commentEmailPro = commentEmailPro;
        this.telephonePro = telephonePro;
        this.commentTelephonePro = commentTelephonePro;
        this.fax = fax;
        this.commentFax = commentFax;
        this.siteWeb = siteWeb;
        this.commentSiteWeb = commentSiteWeb;
        this.dateNaissance = dateNaissance;
        this.nationalite = nationalite;
        this.nomUsuel = nomUsuel;
        this.prenomUsuel = prenomUsuel;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public Ville getVilleDeces() {
        return villeDeces;
    }

    public void setVilleDeces(Ville villeDeces) {
        this.villeDeces = villeDeces;
    }

    public Pays getPaysDeces() {
        return paysDeces;
    }

    public void setPaysDeces(Pays paysDeces) {
        this.paysDeces = paysDeces;
    }

    public String getCommentDeces() {
        return commentDeces;
    }

    public void setCommentDeces(String commentDeces) {
        this.commentDeces = commentDeces;
    }

    public Set<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<Adresse> adresses) {
        this.adresses = adresses;
    }

    public void setDeces(Deces deces) {
        this.commentDeces = deces.getCommentaire();
        this.dateDeces = deces.getDateDeces();
        this.paysDeces = deces.getPays();
        this.villeDeces = deces.getVille();
        this.paysDeces = deces.getPays();
    }

    public Boolean getaHistorique() {
        return aHistorique;
    }

    public void setaHistorique(Boolean aHistorique) {
        this.aHistorique = aHistorique;
    }

}

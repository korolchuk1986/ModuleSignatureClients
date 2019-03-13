package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.Adresse;
import fr.fiducial.signature.feature.clients.model.Deces;
import fr.fiducial.signature.feature.clients.model.Pays;
import fr.fiducial.signature.feature.clients.model.Ville;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PersonneInfo {
    private Long id = null;
    private Long idCivilite = null; // maj
    private String nom = null;
    private String prenoms = null;
    private Long idStatut = null; // maj
    private Long idCapacite = null; // maj
    private String profession = null;
    private Date dateNaissance = null;
    private String nationalite = null;
    private Long idPaysNaissance = null; //maj
    private Long idVilleNaissance = null; //maj
    private String villeEtrangereNaissance = null;
    private String nomUsuel = null;
    private String prenomUsuel = null;
    private Date dateModif = null;
    private String clercReferent = null;
    private String notaireReferent = null;
    private Long idTypeMarital = null;
    private Boolean estPacse = false;
    private Long idConjoint = null;
    private Date dateLiaison = null;
    private Date dateDeces = null;
    private Long idVilleDeces = null; // maj
    private Long idPaysDeces = null; // maj
    private String villeEtrangereDeces = null;
    private String commentDeces = null;
    private String telephonePerso = null;
    private String commentTelephonePerso = null;
    private String emailPerso = null;
    private String commentEmailPerso = null;
    private String telephonePro = null;
    private String commentTelephonePro = null;
    private String emailPro = null;
    private String commentEmailPro = null;
    private String fax = null;
    private String commentFax = null;
    private String siteWeb = null;
    private String commentSiteWeb = null;
    private List<Adresse> adresses = new ArrayList<Adresse>();

    // à vérifier si ordre attributs ok pour laisser lombok le generer
    // ne pas effacer (pas générable par lombok) et ne changer l'ordre des param car lié à une requête jpql
    public PersonneInfo(Long id, Long idCivilite, String nom, String prenoms, Long idStatut, Long idCapacite,
                        String profession, Date dateNaissance, String nationalite, Long idPaysNaissance,
                        Long idVilleNaissance, String villeEtrangereNaissance, String nomUsuel, String prenomUsuel,
                        Date dateModif, String clercReferent, String notaireReferent,
                        Long idTypeMarital, Boolean estPacse, Long idConjoint, Date dateLiaison, Date dateDeces, Long idVilleDeces, Long idPaysDeces,
                        String villeEtrangereDeces, String commentDeces, String telephonePerso, String commentTelephonePerso,
                        String emailPerso, String commentEmailPerso, String telephonePro, String commentTelephonePro,
                        String emailPro, String commentEmailPro, String fax, String commentFax, String siteWeb, String commentSiteWeb) {
        this.id = id;
        this.idCivilite = idCivilite;
        this.nom = nom;
        this.prenoms = prenoms;
        this.idCapacite = idCapacite;
        this.idStatut = idStatut;
        this.idTypeMarital = idTypeMarital;
        this.estPacse = estPacse;
        this.idConjoint = idConjoint;
        this.dateLiaison = dateLiaison;
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
        this.profession = profession;
        this.idPaysNaissance = idPaysNaissance;
        this.idVilleNaissance = idVilleNaissance;
        this.villeEtrangereNaissance = villeEtrangereNaissance;
        this.idPaysDeces = idPaysDeces;
        this.idVilleDeces = idVilleDeces;
        this.commentDeces = commentDeces;
        this.villeEtrangereDeces = villeEtrangereDeces;
        this.dateDeces = dateDeces;
        this.adresses = new ArrayList<>();
        //this.adresses = new ArrayList<>(adresses);
    }

    /*public void setDeces(Deces deces) {
        this.commentDeces = deces.getCommentaire();
        this.dateDeces = deces.getDateDeces();
        this.idPaysDeces = deces.getPays().getId();
        this.idVilleDeces = deces.getVille().getId();
        this.idPaysDeces = deces.getPays().getId();
    }*/

    public String verifieValidite() { // retourne null si ok, sinon cause du pb
        if ((idPaysNaissance == null) ||
                (idVilleNaissance == null) || // ce test devrait être différent avec if ((villeEtrangereNaissance == null) && (idVilleNaissance == null)) mais base mal construite avec un non nullable (pas de temps de corriger)
                (idCapacite == null) ||
                (idCivilite == null) ||
                (idStatut == null) ||
                (idTypeMarital == null) ||
                ((dateDeces != null) && ((idPaysDeces == null) || (idVilleDeces == null)))) {// test different avec villeEtrangereDeces !!!
            return "Les champs idPaysNaissance, idVilleNaissance, idCapacite, idCivilite, idStatut, idTypeMarital et idVilleDeces/idPaysDeces si dateDeces non nulle ne devraient pas être nuls";
        } else {
            return null;
        }
    }

}

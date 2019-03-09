package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.model.dto.PersonneInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PersonneDAO extends JpaRepository<Personne, Long> {
    @Query("select new fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO(p.civilite.civilite, " +
            "p.nom, p.prenoms, ad.num, ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville.cp, " +
            "ad.ville.nom, p.dateModifFiche, p.id) " +
            "from Personne as p, Adresse as ad, Habitation as h " +
            "where p.estClient=true and p.id = h.personne and h.adresse = ad and ad.estPrincipale = true")
    List<ListePersonneDTO> findClients();

    @Query("select new fr.fiducial.signature.feature.clients.model.dto.PersonneInfo(" +
            "p.id, p.civilite.id, p.nom, p.prenoms, p.statut.id, p.capacite.id, " +
            "p.profession, p.dateNaissance, p.nationalite,  p.pays.id, " +
            "p.villeNaissance.id, p.villeEtrangereNaissance, p.nomUsuel, p.prenomUsuel, " +
            "p.dateModifFiche, p.clercReferent, p.notaireReferent, p.typeMarital.id, " +
            "p.estPacse, p.conjoint.id, p.dateLiaison, d.dateDeces, d.ville.id, d.pays.id, " +
            "d.villeEtrangere, d.commentaire, " +
            "p.telephone, p.commentTelephone, p.email, p.commentEmail, p.telephonePro, " +
            "p.commentTelephonePro, p.emailPro, p.commentEmailPro,  " +
            "p.fax, p.commentFax, p.siteWeb, p.commentSiteWeb) " +
            "from Personne as p " +
            "left outer join p.pays " +
            "left outer join p.villeNaissance " +
            "left outer join p.conjoint " +
            "left outer join Deces as d on p.id = d.idPersonne " +
            "where p.id=:id")
    Optional<PersonneInfo> getClientInfo(@Value("id") Long id);
}


package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface PersonneDAO extends JpaRepository<Personne, Long> {
    //@Query("select new fr.fiducial.signature.feature.clients.model.dto.PersonneListeDTO(p.civilite.civilite, p.nom, p.prenoms, ad.num, ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville.cp, ad.ville.nom) from Personne as p, Adresse as ad where p.estClient=true and ad.estPrincipale = true and p=ad.personne")
    //List<PersonneListeDTO> findClients();

    @Query("select new fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO(p.civilite.civilite, " +
            "p.nom, p.prenoms, ad.num, ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville.cp, " +
            "ad.ville.nom, p.dateModifFiche, p.id) " +
            "from Personne as p, Adresse as ad, Habitation as h " +
            "where p.estClient=true and p.id = h.personne and h.adresse = ad and ad.estPrincipale = true")
    List<ListePersonneDTO> findClients();

    @Query("select new fr.fiducial.signature.feature.clients.model.dto.ClientInfoDTO(" +
            "p.id, p.civilite.civilite, p.nom, p.prenoms, p.capacite.capacite, p.statut.statut, " +
            "p.typeMarital.typeMarital, p.estPacse) "+ //, p.telephone ) " +
            "from Personne as p where p.id=:id")
    Optional<ClientInfoDTO> getClientInfo(@Value("id") Long id);
}

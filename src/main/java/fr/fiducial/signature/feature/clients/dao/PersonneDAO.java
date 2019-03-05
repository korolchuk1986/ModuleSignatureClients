package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Personne;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PersonneDAO extends JpaRepository<Personne, Long> {
    //@Query("select new fr.fiducial.signature.feature.clients.model.dto.PersonneListeDTO(p.civilite.civilite, p.nom, p.prenoms, ad.num, ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville.cp, ad.ville.nom) from Personne as p, Adresse as ad where p.estClient=true and ad.estPrincipale = true and p=ad.personne")
    //List<PersonneListeDTO> findClients();

    @Query("select new fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO(p.civilite.civilite, p.nom, p.prenoms, ad.num," +
            " ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville.cp, ad.ville.nom, p.dateModifFiche) from Personne as p, Adresse as ad where p.estClient=true and p.id = ad.personne and ad.estPrincipale = true")
    List<ListePersonneDTO> findClients();

    Iterable<Personne> findAllByEstClientTrue();

    List<Personne> findByNomAndPrenomsAllIgnoreCase(String nom, String prenom);



}

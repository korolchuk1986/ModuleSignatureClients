package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Personne;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneDAO extends CrudRepository<Personne, Long> {
    @Query("select p.civilite, p.nom, p.prenoms, ad.num, ad.ordreVoie, ad.typeVoie, ad.nomVoie, ad.ville, p.dateModifFiche from Personne as p, Adresse as ad where p.estClient=true and ad.estPrincipale = true")
    Iterable<Personne> findClients();

    Iterable<Personne> findAllByEstClientTrue();

    List<Personne> findByNomAndPrenomsAllIgnoreCase(String nom, String prenom);



}

package fr.fiducial.signature.feature.clients.dao;

import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentDAO extends CrudRepository<Document, Long> {
    @Query("select new fr.fiducial.signature.feature.clients.model.dto.DocumentDTO(" +
            "d.id, d.personne.id, d.libelle, d.categorie, d.typeDoc, d.dateEnregistrement) " +
            "from Document as d " +
            "where d.personne.id=:idClient")
    List<DocumentDTO> findDocumentsByClient(@Value("idClient") Long idClient);
}

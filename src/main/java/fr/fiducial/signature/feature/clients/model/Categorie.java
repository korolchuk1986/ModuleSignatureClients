package fr.fiducial.signature.feature.clients.model;
// Generated Mar 10, 2019 4:58:25 AM by Hibernate Tools 5.2.11.Final

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Categorie contient un numéro unique et une description de contenu d'un document
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorie", catalog = "signature_clients")
public class Categorie {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "categorie", nullable = false, length = 200)
    private String categorie;
}

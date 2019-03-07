package fr.fiducial.signature.feature.clients.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.*;

/**
 * Habitation relie une adresse à n personnes
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "habitation", catalog = "signature_clients")
public class Habitation implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_personne", nullable = false)
    private Personne personne;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_adresse", nullable = false)
    private Adresse adresse;
}

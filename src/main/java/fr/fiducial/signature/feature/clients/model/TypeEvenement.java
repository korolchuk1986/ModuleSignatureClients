package fr.fiducial.signature.feature.clients.model;
// Generated Mar 4, 2019 12:07:07 PM by Hibernate Tools 5.2.11.Final
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeEvenement contient un numéro unique et un type évenement (mariage, veuvage, séparation de corps, divorcé, pacs, rupture de pacs)
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "type_evenement", catalog = "signature_clients")
public class TypeEvenement implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "evenement", nullable = false, length = 200)
    private String evenement;
}

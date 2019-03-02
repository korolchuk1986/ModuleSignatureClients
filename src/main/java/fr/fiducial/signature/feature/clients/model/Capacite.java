package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

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
 * Capacite contient un numéro unique non nul et la capacité de la personne (choisie parmi cette énumération:
 * capable, tutelle, curatelle, sauvegarde de justice, et habilitation familiale).
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "capacite", catalog = "signature_clients")
public class Capacite implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "capacite", nullable = false, length = 200)
	private String capacite;
}

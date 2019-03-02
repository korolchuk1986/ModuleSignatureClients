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
 * RegimeMariage contient un numéro unique et une valeur comprise entre
 * Communauté légale réduite aux acquets
 * Communauté légale meubles et acquets
 * Communauté conventionnelle réduite aux acquets
 * Communauté conventionnelle meubles et acquets
 * Communauté universelle
 * Séparation de biens
 * Séparation de biens avec société acquets
 * Participation aux acquets
 * Autre régime français
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "regime_mariage", catalog = "signature_clients")
public class RegimeMariage implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "type", nullable = false, length = 200)
	private String type;
}

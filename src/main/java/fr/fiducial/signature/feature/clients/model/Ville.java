package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * La classe ville contient un numéro unique non nul, un code postal et un nom. Le code postal peut être vide,
 * si la ville est une ville non française.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ville", catalog = "signature_clients")
public class Ville implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cp", length = 5)
	private String cp;

	@Column(name = "nom", nullable = false, length = 200)
	private String nom;
}

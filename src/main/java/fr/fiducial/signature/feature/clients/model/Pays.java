package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pays contient un numéro unique, un nom, et la nationalité associée
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "pays", catalog = "signature_clients")
public class Pays implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "nom", nullable = false, length = 200)
	private String nom;

	@Column(name = "nationalite", nullable = false, length = 200)
	private String nationalite;
}

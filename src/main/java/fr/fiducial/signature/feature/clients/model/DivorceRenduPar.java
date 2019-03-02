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
 * DivorceRenduPar contient un numéro unique et une valeur comprise entre tribunal de grande instance et cour d'appel
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "divorce_rendu_par", catalog = "signature_clients")
public class DivorceRenduPar implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "rendu_par", nullable = false, length = 200)
	private String renduPar;
}

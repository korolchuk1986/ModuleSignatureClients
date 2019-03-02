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
 * CauseRupturePacs contient un numéro unique et la cause de la rupture du PACS (dans l'énumération:
 * mariage, décès, rupture, inconnue)
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "cause_rupture_pacs", catalog = "signature_clients")
public class CauseRupturePacs implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "cause", nullable = false, length = 200)
	private String cause;
}

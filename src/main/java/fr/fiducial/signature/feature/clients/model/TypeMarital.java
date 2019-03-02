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
 * TypeMarital contient un numéro unique et une valeur parmi célibataire, marié(e), divorcé(e), veuf/ve,
 * séparé(e) de corps
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "type_marital", catalog = "signature_clients")
public class TypeMarital implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "type_marital", nullable = false, length = 200)
	private String typeMarital;
}

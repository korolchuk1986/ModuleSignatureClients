package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

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
 * TypeMarital generated by hbm2java
 */
@Entity
@Table(name = "type_marital", catalog = "signature_clients")
public class TypeMarital implements java.io.Serializable {

	private Long id;
	private String typeMarital;
	private Set<Evenement> evenements = new HashSet<Evenement>(0);

	public TypeMarital() {
	}

	public TypeMarital(String typeMarital) {
		this.typeMarital = typeMarital;
	}

	public TypeMarital(String typeMarital, Set<Evenement> evenements) {
		this.typeMarital = typeMarital;
		this.evenements = evenements;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "type_marital", nullable = false, length = 200)
	public String getTypeMarital() {
		return this.typeMarital;
	}

	public void setTypeMarital(String typeMarital) {
		this.typeMarital = typeMarital;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeMarital")
	public Set<Evenement> getEvenements() {
		return this.evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

}

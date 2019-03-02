package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CauseRupturePacs generated by hbm2java
 */
@Entity
@Table(name = "cause_rupture_pacs", catalog = "signature_clients")
public class CauseRupturePacs implements java.io.Serializable {

	private Long id;
	private String cause;

	public CauseRupturePacs() {
	}

	public CauseRupturePacs(String cause) {
		this.cause = cause;
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

	@Column(name = "cause", nullable = false, length = 200)
	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}
}

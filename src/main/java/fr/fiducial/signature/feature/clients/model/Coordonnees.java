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
 * Coordonnees generated by hbm2java
 */
@Entity
@Table(name = "coordonnees", catalog = "signature_clients")
public class Coordonnees implements java.io.Serializable {

	private Long id;
	private String telephone;
	private String commentTelephone;
	private String telephonePro;
	private String commentTelephonePro;
	private String email;
	private String commentEmail;
	private String emailPro;
	private String commentEmailPro;
	private String fax;
	private String commentFax;
	private String siteWeb;
	private String commentSiteWeb;
	private Set<Personne> personnes = new HashSet<Personne>(0);

	public Coordonnees() {
	}

	public Coordonnees(String telephone) {
		this.telephone = telephone;
	}

	public Coordonnees(String telephone, String commentTelephone, String telephonePro, String commentTelephonePro,
			String email, String commentEmail, String emailPro, String commentEmailPro, String fax, String commentFax,
			String siteWeb, String commentSiteWeb, Set<Personne> personnes) {
		this.telephone = telephone;
		this.commentTelephone = commentTelephone;
		this.telephonePro = telephonePro;
		this.commentTelephonePro = commentTelephonePro;
		this.email = email;
		this.commentEmail = commentEmail;
		this.emailPro = emailPro;
		this.commentEmailPro = commentEmailPro;
		this.fax = fax;
		this.commentFax = commentFax;
		this.siteWeb = siteWeb;
		this.commentSiteWeb = commentSiteWeb;
		this.personnes = personnes;
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

	@Column(name = "telephone", nullable = false, length = 200)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "comment_telephone", length = 200)
	public String getCommentTelephone() {
		return this.commentTelephone;
	}

	public void setCommentTelephone(String commentTelephone) {
		this.commentTelephone = commentTelephone;
	}

	@Column(name = "telephone_pro", length = 200)
	public String getTelephonePro() {
		return this.telephonePro;
	}

	public void setTelephonePro(String telephonePro) {
		this.telephonePro = telephonePro;
	}

	@Column(name = "comment_telephone_pro", length = 200)
	public String getCommentTelephonePro() {
		return this.commentTelephonePro;
	}

	public void setCommentTelephonePro(String commentTelephonePro) {
		this.commentTelephonePro = commentTelephonePro;
	}

	@Column(name = "email", length = 200)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "comment_email", length = 200)
	public String getCommentEmail() {
		return this.commentEmail;
	}

	public void setCommentEmail(String commentEmail) {
		this.commentEmail = commentEmail;
	}

	@Column(name = "email_pro", length = 200)
	public String getEmailPro() {
		return this.emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	@Column(name = "comment_email_pro", length = 200)
	public String getCommentEmailPro() {
		return this.commentEmailPro;
	}

	public void setCommentEmailPro(String commentEmailPro) {
		this.commentEmailPro = commentEmailPro;
	}

	@Column(name = "fax", length = 200)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "comment_fax", length = 200)
	public String getCommentFax() {
		return this.commentFax;
	}

	public void setCommentFax(String commentFax) {
		this.commentFax = commentFax;
	}

	@Column(name = "site_web", length = 200)
	public String getSiteWeb() {
		return this.siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	@Column(name = "comment_site_web", length = 20)
	public String getCommentSiteWeb() {
		return this.commentSiteWeb;
	}

	public void setCommentSiteWeb(String commentSiteWeb) {
		this.commentSiteWeb = commentSiteWeb;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "coordonnees")
	public Set<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

}

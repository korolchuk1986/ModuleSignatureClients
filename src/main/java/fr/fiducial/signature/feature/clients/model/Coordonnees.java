package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Coordonnees d'un client contient une numéro unique (qui est le numéro du client), la personne associée,
 * son numéro de téléphone perso avec un commentaire, son numéro de téléphone pro avec un commentaire,
 * son email perso avec un commentaire, son email pro avec un commentaire, son numéro de fax avec un
 * comentaire, son site web avec un commentaire.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "coordonnees", catalog = "signature_clients")
public class Coordonnees implements java.io.Serializable {
	@GenericGenerator(name = "fr.fiducial.signature.feature.clients.model.CoordonneesIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "fr.fiducial.signature.feature.clients.model.CoordonneesIdGenerator")
	@Column(name = "id_personne", unique = true, nullable = false)
	private long idPersonne;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Personne personne;

	@Column(name = "telephone", nullable = false, length = 200)
	private String telephone;

	@Column(name = "comment_telephone", length = 200)
	private String commentTelephone;

	@Column(name = "telephone_pro", length = 200)
	private String telephonePro;

	@Column(name = "comment_telephone_pro", length = 200)
	private String commentTelephonePro;

	@Column(name = "email", length = 200)
	private String email;

	@Column(name = "comment_email", length = 200)
	private String commentEmail;

	@Column(name = "email_pro", length = 200)
	private String emailPro;

	@Column(name = "comment_email_pro", length = 200)
	private String commentEmailPro;

	@Column(name = "fax", length = 200)
	private String fax;

	@Column(name = "comment_fax", length = 200)
	private String commentFax;

	@Column(name = "site_web", length = 200)
	private String siteWeb;

	@Column(name = "comment_site_web", length = 20)
	private String commentSiteWeb;
}
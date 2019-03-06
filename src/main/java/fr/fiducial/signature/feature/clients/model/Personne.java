package fr.fiducial.signature.feature.clients.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.extern.flogger.Flogger;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "personne", catalog = "signature_clients")
public class Personne implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "est_client", nullable = false)
	private boolean estClient;

	@Column(name = "nom", nullable = false, length = 200)
	private String nom;

	@Column(name = "prenoms", length = 200)
	private String prenoms;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", length = 10)
	private Date dateNaissance;

	@Column(name = "ville_etrangere_naissance", length = 50)
	private String villeEtrangereNaissance;

	@Column(name = "nationalite", length = 50)
	private String nationalite;

	@Column(name = "profession", length = 200)
	private String profession;

	@Column(name = "nom_usuel", length = 200)
	private String nomUsuel;

	@Column(name = "prenom_usuel", length = 200)
	private String prenomUsuel;

	@Column(name = "est_pacse", nullable = false)
	private boolean estPacse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_capacite")
	private Capacite capacite;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_civilite")
	private Civilite civilite;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pays_naissance")
	private Pays pays;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conjoint")
	private Personne conjoint;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_statut")
	private Statut statut;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type_marital", nullable = false)
	private TypeMarital typeMarital;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ville_naissance")
	private Ville villeNaissance;

	@Column(name = "clerc_referent", length = 200)
	private String clercReferent;

	@Column(name = "notaire_referent", length = 200)
	private String notaireReferent;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_modif_fiche", length = 10)
	private Date dateModifFiche;

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

	@Column(name = "site_web", length = 20)
	private String siteWeb;

	@Column(name = "comment_site_web", length = 20)
	private String commentSiteWeb;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "personne")
	private Deces deces;



	/*
	private Set<Evenement> evenements = new HashSet<Evenement>(0);
	private Set<Personne> personnes = new HashSet<Personne>(0);
	private Set<Document> documents = new HashSet<Document>(0);
	private Set<Evenement> evenements_1 = new HashSet<Evenement>(0);


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "historique", catalog = "signature_clients", joinColumns = {
			@JoinColumn(name = "id_client", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "id_evenement", nullable = false, updatable = false) })
	public Set<Evenement> getEvenements() {
		return this.evenements;
	}

	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Personne> getPersonnes() {
		return this.personnes;
	}

	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Evenement> getEvenements_1() {
		return this.evenements_1;
	}

	public void setEvenements_1(Set<Evenement> evenements_1) {
		this.evenements_1 = evenements_1;
	}
*/
}

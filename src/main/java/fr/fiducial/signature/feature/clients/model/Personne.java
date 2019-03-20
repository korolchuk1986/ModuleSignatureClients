package fr.fiducial.signature.feature.clients.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.fiducial.signature.feature.clients.model.dto.PersonneInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.extern.flogger.Flogger;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_capacite", nullable = false)
	private Capacite capacite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_civilite", nullable = false)
	private Civilite civilite;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pays_naissance", nullable = false)
	private Pays pays;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conjoint")
	private Personne conjoint;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_statut", nullable = false)
	private Statut statut;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_type_marital", nullable = false)
	private TypeMarital typeMarital;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_liaison", length = 10)
	private Date dateLiaison;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ville_naissance")
	private Ville villeNaissance;

	@Column(name = "clerc_referent", length = 200)
	private String clercReferent;

	@Column(name = "notaire_referent", length = 200)
	private String notaireReferent;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_modif_fiche", length = 10)
	private Date dateModifFiche;

	@Column(name = "telephone", length = 200)
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

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinTable(name = "habitation", catalog = "signature_clients", joinColumns = {
			@JoinColumn(name = "id_personne", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "id_adresse", nullable = false, updatable = false) })
	private List<Adresse> adresses = new ArrayList<>();

	public Personne(Boolean estClient, String nom, String prenoms, Date dateNaissance,
					String villeEtrangereNaissance, String nationalite, String profession,
					String nomUsuel, String prenomUsuel, Boolean estPacse, Capacite capacite,
					Civilite civilite, Pays paysNaissance, Statut statut, TypeMarital typeMarital,
					Date dateLiaison, Ville villeNaissance, String clercReferent, String notaireReferent,
					String telephone, String commentTelephone, String telephonePro,
					String commentTelephonePro, String email, String commentEmail, String emailPro,
					String commentEmailPro, String fax, String commentFax, String siteWeb,
					String commentSiteWeb, List<Adresse> adresses) {
		this.dateModifFiche = new java.sql.Date(Instant.now().toEpochMilli());
		this.estClient = estClient;
		this.nom = nom;
		this.prenoms = prenoms;
		this.dateNaissance = dateNaissance;
		this.villeEtrangereNaissance = villeEtrangereNaissance;
		this.nationalite = nationalite;
		this.profession = profession;
		this.nomUsuel = nomUsuel;
		this.prenomUsuel = prenomUsuel;
		this.estPacse = estPacse;
		this.capacite = capacite;
		this.civilite = civilite;
		this.pays = paysNaissance;
		this.statut = statut;
		this.typeMarital = typeMarital;
		this.dateLiaison = dateLiaison;
		this.villeNaissance = villeNaissance;
		this.clercReferent = clercReferent;
		this.notaireReferent = notaireReferent;
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
		this.adresses = adresses;
	}

	public void update(PersonneInfo personneInfo) {
		this.dateModifFiche = new java.sql.Date(Instant.now().toEpochMilli());
		//java.sql.Date.valueOf(LocalDate.now(ZoneId.systemDefault())); // ne pas utiliser car pb avec mysql et jdbc pas utc et donc date incorrecte, manque un jour
		this.nom = personneInfo.getNom();
		this.prenoms = personneInfo.getPrenoms();
		this.dateNaissance = personneInfo.getDateNaissance();
		this.villeEtrangereNaissance = personneInfo.getVilleEtrangereNaissance();
		this.nationalite = personneInfo.getNationalite();
		this.profession = personneInfo.getProfession();
		this.nomUsuel = personneInfo.getNomUsuel();
		this.prenomUsuel = personneInfo.getPrenomUsuel();
		this.estPacse = personneInfo.getEstPacse();
		this.dateLiaison = personneInfo.getDateLiaison();
		this.clercReferent = personneInfo.getClercReferent();
		this.notaireReferent = personneInfo.getNotaireReferent();
		this.telephone = personneInfo.getTelephonePerso();
		this.commentTelephone = personneInfo.getCommentTelephonePerso();
		this.telephonePro = personneInfo.getTelephonePro();
		this.commentTelephonePro = personneInfo.getCommentTelephonePro();
		this.email = personneInfo.getEmailPerso();
		this.commentEmail = personneInfo.getCommentEmailPerso();
		this.emailPro = personneInfo.getEmailPro();
		this.commentEmailPro = personneInfo.getCommentEmailPro();
		this.fax = personneInfo.getFax();
		this.commentFax = personneInfo.getCommentFax();
		this.siteWeb = personneInfo.getSiteWeb();
		this.commentSiteWeb = personneInfo.getCommentSiteWeb();
	}

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

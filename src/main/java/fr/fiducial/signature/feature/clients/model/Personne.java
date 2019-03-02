package fr.fiducial.signature.feature.clients.model;

import lombok.Data;
//import lombok.extern.flogger.Flogger;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Flogger
@Entity
@Data
@Table(name = "personne", catalog = "signature_clients")
public class Personne implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_capacite")
	private Capacite capacite;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_coordonnees")
	private Coordonnees coordonnees;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pays_naissance")
	private Pays pays;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_statut")
	private Statut statut;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ville_naissance")
	private Ville ville;

	private boolean estClient;
	private String civilite;
	private String nom;
	private String prenoms;
	private Date dateNaissance;
	private String nationalite;
	private String profession;
	private String nomUsuel;
	private String prenomUsuel;
	private Long idEtatMaritalPacs;
	private String clercReferent;
	private String notaireReferent;
	private Date dateModifFiche;
	private Long idCoordonnes;
	private Long idDeces;

	public Personne() {
	}

}

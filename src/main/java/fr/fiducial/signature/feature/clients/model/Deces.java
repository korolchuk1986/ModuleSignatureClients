package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Deces contient le numéro de la personne décédée, le pays, la ville, la date du décès et un commentaire
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "deces", catalog = "signature_clients")
public class Deces implements java.io.Serializable {
	@GenericGenerator(name = "fr.fiducial.signature.feature.clients.model.DecesIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "fr.fiducial.signature.feature.clients.model.DecesIdGenerator")
	@Column(name = "id_personne", unique = true, nullable = false)
	private long idPersonne;

	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private Personne personne;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pays")
	private Pays pays;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ville")
	private Ville ville;

	@Column(name = "ville_etrangere", length = 200)
	private String villeEtrangere;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_deces", nullable = false, length = 10)
	private Date dateDeces;

	@Column(name = "commentaire", length = 200)
	private String commentaire;

	public Deces(Pays pays, Ville ville, String villeEtrangere, Date dateDeces, String commentaire) {
		//this.personne = personne;
        //this.idPersonne = idPersonne;
		this.pays = pays;
		this.ville = ville;
		this.villeEtrangere = villeEtrangere;
		this.dateDeces = dateDeces;
		this.commentaire = commentaire;
	}
}

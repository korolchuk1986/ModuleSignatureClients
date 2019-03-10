package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Document contient un numéro unique, le client auquel est rattaché ce document, un libellé, une catégorie,
 * le type du doc, sa date d'enregistrement, et son contenu
 *
 */
@Data
@NoArgsConstructor

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "document", catalog = "signature_clients")
public class Document implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client", nullable = false)
	private Personne personne; //à supprimer je pense

	@Column(name = "libelle", nullable = false, length = 200)
	private String libelle;

	@Column(name = "categorie", length = 200)
	private String categorie;

	@Column(name = "type_doc", nullable = false, length = 200)
	private String typeDoc;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_enregistrement", nullable = false, length = 10)
	private Date dateEnregistrement;

	@Column(name = "lien_vers_contenu", nullable = false, length = 200)
	private String lienVersContenu;

	public Document(DocumentDTO documentDTO, Personne personne, String documentPath) {
		this.personne = personne;
		this.categorie = documentDTO.getCategorie();
		this.libelle = documentDTO.getLibelle();
		this.dateEnregistrement = java.sql.Date.valueOf(LocalDate.now());
		this.lienVersContenu = documentPath;
		this.typeDoc = documentDTO.getTypeDoc();
	}
}

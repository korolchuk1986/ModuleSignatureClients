package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import lombok.Data;
import lombok.NoArgsConstructor;

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

	@Column(name = "typeDoc", nullable = false, length = 200)
	private String typeDoc;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateEnregistrement", nullable = false, length = 19)
	private Date dateEnregistrement;

	@Column(name = "contenu", nullable = false)
	private byte[] contenu;
}

package fr.fiducial.signature.feature.clients.model;
// Generated Mar 1, 2019 11:53:13 AM by Hibernate Tools 5.2.11.Final

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;

/**
 * Historique relie un client à un événement
 */
@Data
@NoArgsConstructor
@Entity
@IdClass(Historique.HistoriqueId.class)
@Table(name = "historique", catalog = "signature_clients")
public class Historique implements java.io.Serializable {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_evenement", nullable = false)
	private Evenement evenement;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client", nullable = false)
	private Personne personne;



	public static class HistoriqueId implements Serializable {

		private Evenement evenement;
		private Personne personne;


		public HistoriqueId() {}

		public HistoriqueId(Evenement evenement, Personne personne) {
			this.personne = personne;
			this.evenement = evenement;
		}

		@Override
		public boolean equals(Object o) {

			if (o == this) {
				return true;
			}
			if (!(o instanceof Historique)) {
				return false;
			}
			Historique historique = (Historique) o;
			return Objects.equals(personne, historique.getPersonne()) &&
					Objects.equals(evenement, historique.getEvenement());
		}

		@Override
		public int hashCode() {
			return Objects.hash(personne, evenement);
		}
	}
}

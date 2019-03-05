package fr.fiducial.signature.feature.clients.model;
// Generated Mar 4, 2019 10:53:41 AM by Hibernate Tools 5.2.11.Final

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

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
 * Civilite contient un numéro unique et une civilité M, Mme, ou Mlle
 */
@Data
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "civilite", catalog = "signature_clients")
public class Civilite implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "civilite", nullable = false, length = 5)
    private String civilite;
}

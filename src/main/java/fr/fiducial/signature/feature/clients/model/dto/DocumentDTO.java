package fr.fiducial.signature.feature.clients.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO {
    private Long id;
    private Long idClient;
    private String libelle;
    private String categorie;
    private String typeDoc;
    private Date dataEnregistrement;
}

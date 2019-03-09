package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDTO {
    private PersonneInfo client = null;
    private PersonneInfo conjoint = null;
    private Set<Adresse> adresses;
    private List<DocumentDTO> documents;
    private Boolean aHistorique = false;
}

package fr.fiducial.signature.feature.clients.model.dto;

import fr.fiducial.signature.feature.clients.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoFormulaireDTO {
    private Iterable<Capacite> capacites;
    private Iterable<Civilite> civilites;
    private Iterable<Statut> statuts;
    private Iterable<TypeMarital> typeMarital;
    private Iterable<Pays> pays;
    private Iterable<Ville> villes;
    private Iterable<Categorie> categories;
}

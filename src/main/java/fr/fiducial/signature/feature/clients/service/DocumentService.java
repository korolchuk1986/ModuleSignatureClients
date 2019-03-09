package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {
    Document create(Document document);
    Document get(Long id);

    List<DocumentDTO> getDocumentsByClient(Long idClient);
}

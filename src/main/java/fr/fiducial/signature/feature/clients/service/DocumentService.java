package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Document;

public interface DocumentService {
    Document create(Document document);
    Document get(Long id);
}

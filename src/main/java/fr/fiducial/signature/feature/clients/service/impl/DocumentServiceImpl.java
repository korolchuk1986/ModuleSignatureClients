package fr.fiducial.signature.feature.clients.service.impl;

import fr.fiducial.signature.feature.clients.dao.DocumentDAO;
import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import fr.fiducial.signature.feature.clients.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    private DocumentDAO documentDAO;

    public DocumentServiceImpl(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    @Override
    public Document create(Document document) {
        return null;
    }

    @Override
    public Document get(Long id) {
        return null;
    }

    @Override
    public List<DocumentDTO> getDocumentsByClient(Long idClient) {
        return documentDAO.findDocumentsByClient(idClient);

        /*
        // mets à null les liens vers les emplacements des fichiers sur le serveur par sécurité (pas une info à divulger)
        if (documents != null) {
            for (Document doc : documents) {
                doc.setLienVersContenu(null);
            }
        }
        */
    }
}

package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public interface DocumentService {
    Document get(Long id);
    List<DocumentDTO> getDocumentsByClient(Long idClient);
    DocumentDTO uploadDocumentForClient(Long idClient, DocumentDTO documentDTO,
                                        MultipartFile multipartFile, Path documentPath, String relativePath) throws IOException;
}

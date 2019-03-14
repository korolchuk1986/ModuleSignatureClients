package fr.fiducial.signature.feature.clients.service;

import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface DocumentService {
    Path getPath(Long idClient, Long idDocument) throws ProblemeBaseException;
    List<DocumentDTO> getDocumentsByClient(Long idClient);
    DocumentDTO uploadDocumentForClient(Long idClient, MultipartFile multipartFile, Path documentPath, String relativePath,
                                        String libelle, String typeDoc) throws IOException;
    DocumentDTO updateDocumentByClient(Long idClient, Long idDoc, DocumentDTO documentDTO, boolean isUpdateClient) throws ProblemeBaseException;
    void deleteDocument(Long idClient, Long idDocument) throws ProblemeBaseException;
}

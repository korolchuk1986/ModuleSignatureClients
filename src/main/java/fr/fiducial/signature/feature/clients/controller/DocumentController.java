package fr.fiducial.signature.feature.clients.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.fiducial.signature.feature.clients.model.Document;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import fr.fiducial.signature.feature.clients.model.dto.ListePersonneDTO;
import fr.fiducial.signature.feature.clients.service.DocumentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "signature", produces = "application/json")
public class DocumentController {
    private DocumentService documentService;
    private static final String PATH_ARCHIVE = "archiveClients"; // à mettre peut-être dans un fichier .properties

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/client/{id}/documents", method = GET)
    public List<DocumentDTO> getDocumentsByClient(@PathVariable("id") Long idClient) {
        return  documentService.getDocumentsByClient(idClient);
    }
    @RequestMapping(value = "/client/{id}/document/upload", method = POST, consumes = { "multipart/mixed", "multipart/form-data" })
    public @ResponseBody ResponseEntity<?> uploadDocumentForClient(@PathVariable("id") Long idClient,
                              //@RequestParam("documentDtoString") String JSONString,
                              @RequestParam("file") MultipartFile multipartFile) {
        try {
            // Décoder le Json qui décrit le document
            //DocumentDTO documentDTO  = new ObjectMapper().readValue(JSONString, DocumentDTO.class);

            // récuperer le fichier envoyé
            String originalFileName = multipartFile.getOriginalFilename();
            int pos = originalFileName.lastIndexOf(".");
            if (pos == -1) {
                return new ResponseEntity<>("This file has no extension; it cannot be uploaded", HttpStatus.BAD_REQUEST);
            }
            String libelle = originalFileName.substring(0, pos);
            String typeDoc = originalFileName.substring(pos+1);
            Path path = FileSystems.getDefault().getPath(PATH_ARCHIVE, String.valueOf(idClient));
            String relativePath = path.toString();

            // crée le ou les répertoires s'ils n'existent pas
            if (!Files.isDirectory(path)) {
                Files.createDirectories(path);
            }
            path = FileSystems.getDefault().getPath(PATH_ARCHIVE, String.valueOf(idClient), originalFileName);
            // Si ce fichier existe déjà, erreur
            if (Files.exists(path)) {
                return new ResponseEntity<>("This file cannot be downloaded twice", HttpStatus.BAD_REQUEST);
            }
            // appeller le service document pour stockage
            DocumentDTO documentDTO = documentService.uploadDocumentForClient(idClient, multipartFile,
                    path.toAbsolutePath(), relativePath, libelle, typeDoc);
            return new ResponseEntity<>(documentDTO, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Upload problem with file", HttpStatus.BAD_REQUEST);
        }
    }
}

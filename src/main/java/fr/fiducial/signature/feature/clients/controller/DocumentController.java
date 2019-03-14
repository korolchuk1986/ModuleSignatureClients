package fr.fiducial.signature.feature.clients.controller;

import fr.fiducial.signature.feature.clients.exception.ProblemeBaseException;
import fr.fiducial.signature.feature.clients.model.dto.DocumentDTO;
import fr.fiducial.signature.feature.clients.service.DocumentService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(path = "signature", produces = "application/json")
public class DocumentController {
    private DocumentService documentService;
    private static final String PATH_ARCHIVE = "archiveClients"; // à mettre peut-être dans un fichier .properties
    // pour mieux gérer les exceptions, à voir https://www.baeldung.com/exception-handling-for-rest-with-spring

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @RequestMapping(value = "/client/{id}/documents", method = GET)
    public @ResponseBody ResponseEntity<?>  getDocumentsByClient(@PathVariable("id") Long idClient) {
        return new ResponseEntity<>(documentService.getDocumentsByClient(idClient), HttpStatus.OK);
    }

    @RequestMapping(value = "/client/{id}/document/{idDoc}/update", method = PUT)
    public @ResponseBody ResponseEntity<?> updateDocumentByClient(@PathVariable("id") Long idClient, @PathVariable("idDoc") Long idDoc,
                                                    @RequestBody DocumentDTO documentDTO) {
        //DocumentDTO documentDTO  = new ObjectMapper().readValue(JSONString, DocumentDTO.class);
        try {
            documentDTO = documentService.updateDocumentByClient(idClient, idDoc, documentDTO, false);

            return new ResponseEntity<>(documentDTO, HttpStatus.OK);
        } catch (ProblemeBaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
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
            return new ResponseEntity<>("Upload problem with the file", HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping(value = "/client/{idClient}/document/{idDocument}/delete", method = DELETE)
    public @ResponseBody ResponseEntity<?> delete(@PathVariable("idClient") Long idClient, @PathVariable("idDocument") Long idDocument) {
        try {
            documentService.deleteDocument(idClient, idDocument);
        } catch (ProblemeBaseException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/client/{idClient}/document/{idDocument}/download", method = GET)
    public ResponseEntity<Resource> downloadDocument(@PathVariable("idClient") Long idClient,
                                                     @PathVariable("idDocument") Long idDocument) throws IOException {
        try {
            Path path = documentService.getPath(idClient, idDocument);
            if (path == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                //return ResponseEntity.badRequest().body(null);
            }

            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path.toAbsolutePath()));

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(Files.size(path))
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        } catch (ProblemeBaseException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}

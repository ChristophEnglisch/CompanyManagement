package cenglisch.document.document;

import cenglisch.document.document.determine.DocumentDetermineService;
import cenglisch.document.document.determine.DocumentType;
import cenglisch.document.service.FileSystemService;
import cenglisch.document.service.OcrService;
import cenglisch.document.storage.Storage;
import cenglisch.document.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class DocumentApplicationService {

    @Autowired
    private FileSystemService fileSystemService;
    @Autowired
    private OcrService ocrService;
    @Autowired
    private StorageService storageService;
    @Autowired
    private DocumentDetermineService documentDetermineService;

    public DocumentResponse determineDocumentType(MultipartFile file) {
        File fileSystemStoredFile = fileSystemService.storeMultipartFile(file);
        String extractedText = ocrService.extractTextFromFile(fileSystemStoredFile);
        DocumentType documentType = documentDetermineService.determineFileType(extractedText);

        Storage storage = storageService.storeFileContent(
                "cenglisch",
                documentType,
                fileSystemStoredFile.getPath(),
                extractedText
        );

        return new DocumentResponse(
                storage.getId(),
                documentType,
                file.getName()
        );
    }
}

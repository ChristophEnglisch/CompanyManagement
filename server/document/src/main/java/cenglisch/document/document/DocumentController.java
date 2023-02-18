package cenglisch.document.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("v1/document")
public class DocumentController {
    @Autowired
    private DocumentApplicationService documentApplicationService;

    @PostMapping(value = "place", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DocumentResponse placeDocument(@RequestPart("file") MultipartFile file){
        return documentApplicationService.determineDocumentType(file);
    }
}

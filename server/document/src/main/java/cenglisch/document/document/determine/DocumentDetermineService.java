package cenglisch.document.document.determine;

import org.springframework.stereotype.Service;

@Service
public class DocumentDetermineService {

    public DocumentType determineFileType(String content) {
        String contentUpper = content.toUpperCase().replaceAll("\\s+","");
        for (Determination determination : Determination.getDeterminationPool()) {
            if(determination.determine(contentUpper)){
                return determination.getDocumentType();
            }
        }
        return null;
    }
}

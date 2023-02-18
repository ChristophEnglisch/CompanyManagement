package cenglisch.document.document.determine;

public class LebenslaufDetermination implements Determination{

    public boolean determine(String fileContent) {
        return fileContent.contains("LEBENSLAUF");
    }

    public DocumentType getDocumentType() {
        return DocumentType.LEBENSLAUF;
    }
}

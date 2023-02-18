package cenglisch.document.document.determine;

public class AnschreibenDetermination implements Determination{
    public boolean determine(String fileContent) {
        return fileContent.contains("BEWERBUNG") || fileContent.contains("ANSCHREIBEN");
    }

    public DocumentType getDocumentType() {
        return DocumentType.ANSCHREIBEN;
    }
}

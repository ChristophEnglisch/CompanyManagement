package cenglisch.document.document.determine;

public class ZeugnisDetermination implements Determination {


    public boolean determine(String fileContent) {
        return fileContent.contains("ZEUGNIS");
    }

    public DocumentType getDocumentType() {
        return DocumentType.ZEUGNIS;
    }
}

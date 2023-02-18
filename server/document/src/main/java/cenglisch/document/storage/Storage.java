package cenglisch.document.storage;

import cenglisch.document.document.determine.DocumentType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "storage")
public class Storage {
    @Id
    private String id;
    @Column
    private String reference;
    @Column
    private String path;
    @Lob
    @Column
    private String content;
    @Column
    @Enumerated
    private DocumentType documentType;

    public Storage() {
    }

    public Storage(String reference, String path, String content, DocumentType documentType) {
        //TODO generate UUID over hibernate
        this.id = UUID.randomUUID().toString().toUpperCase();
        this.reference = reference;
        this.path = path;
        this.content = content;
        this.documentType = documentType;
    }

    public String getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getPath() {
        return path;
    }

    public String getContent() {
        return content;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }
}

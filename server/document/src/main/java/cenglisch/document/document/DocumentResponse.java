package cenglisch.document.document;


import cenglisch.document.document.determine.DocumentType;

public record DocumentResponse(String id, DocumentType documentType, String name) {
}

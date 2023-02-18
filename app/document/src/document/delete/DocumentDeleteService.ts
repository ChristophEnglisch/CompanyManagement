import apiClient from "../../http-client";
import DocumentDto from "../DocumentDto";

class DocumentDeleteService {
    public deleteDocument(document: DocumentDto): Promise<any> {
        return apiClient.delete('/storage?id=' + document.id);
    }
}

export default new DocumentDeleteService()
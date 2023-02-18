import apiClient from "../../http-client";

class DocumentUploadService {
    public uploadFile(file: FormData): Promise<any> {
        return apiClient.post('/place', file, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
    }
}

export default new DocumentUploadService()
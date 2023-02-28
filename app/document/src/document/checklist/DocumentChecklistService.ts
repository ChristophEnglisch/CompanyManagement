import apiClient from "../../http-client";

class DocumentChecklistService {
    public getFiles(): Promise<any> {
        return apiClient.get('/storage');
    }
}
export default new DocumentChecklistService()
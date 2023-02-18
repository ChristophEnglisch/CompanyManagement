import axios, { AxiosInstance } from 'axios';

const apiClient: AxiosInstance = axios.create({
    baseURL: 'http://localhost:8000/document',
    headers: {
        'Content-type': 'application/json',
    },
});
export default apiClient

import {defineStore} from "pinia";
import DocumentDto from "../document/DocumentDto";

export const documentStore = defineStore('document', {
    state: () =>
        ({
            documents: [] as DocumentDto[]
        }),
})
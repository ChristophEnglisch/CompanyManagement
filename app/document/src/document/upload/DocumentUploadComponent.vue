<script lang="ts">

import {Vue} from "vue-class-component";
import DocumentUploadService from "./DocumentUploadService";
import { documentStore } from "@/store";

export default class DocumentUploadComponent extends Vue {

  private store = documentStore();

  private fileUpload = null

  private fileUploadInProgress = false

  private fileUploaded = false

  private documentType = ''

  public async uploadFile(): Promise<void> {
    this.fileUploaded = false
    this.fileUploadInProgress = true
    const formData = new FormData()
    formData.append('file', this.fileUpload[0])
    await DocumentUploadService.uploadFile(formData).then(
        response => {
          this.store.$patch((state) => {
            state.documents.push(response.data)
          })
          this.documentType = response.data.documentType
          this.fileUploaded = true
        }
    )
    this.fileUpload = null
    this.fileUploadInProgress = false
  }

  public get uploadedFileText(): string {
    if (this.documentType === null) {
      return "Unterlage wurde nicht erkannt"
    }
    return "Unterlage wurde als " + this.documentType + " erkannt"
  }

}
</script>
<template>
    <v-container>
        <v-alert
                v-model="fileUploaded"
                type="success"
        >{{ uploadedFileText }}
        </v-alert>

        <v-card>
            <v-card-title>
                Bewerbungsunterlagen
            </v-card-title>
            <v-card-item>
                <v-file-input
                        id="fileInput"
                        counter
                        show-size
                        accept=".pdf"
                        truncate-length="25"
                        @change="fileChange"
                        v-model="fileUpload"
                ></v-file-input>
                <v-progress-linear
                        :active="fileUploadInProgress"
                        indeterminate
                        color="cyan"
                />
            </v-card-item>
            <v-card-actions>
                <v-btn
                        :disabled="!fileUpload"
                        block
                        x-large
                        outlined
                        @click="uploadFile"
                >
                    Dokument hochladen und prüfen
                </v-btn
>
            </v-card-actions>
        </v-card>
    </v-container>
</template>
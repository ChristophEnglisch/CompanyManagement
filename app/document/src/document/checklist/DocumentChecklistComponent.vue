<script lang="ts">
import {Options, Vue} from "vue-class-component";
import {documentStore} from "../../store";
import DocumentDto from "../DocumentDto";
import DeleteDialog from "../../components/DeleteDialog.vue";
import {DocumentType} from "../DocumentType";
import DocumentChecklistService from "./DocumentChecklistService";

@Options({
  components: {
    DeleteDialog
  }
})
export default class DocumentUploadComponent extends Vue {

  private store = documentStore();

  private deleteItem = {
    visibility: false,
    text: "Möchten Sie die Unterlage wirklich löschen?",
    item: null
  }

  private documents = {
    ZEUGNIS: {
      type: DocumentType.ZEUGNIS,
      text: "Zeugnis",
      visibility: false,
      reference: null
    },
    LEBENSLAUF: {
      type: DocumentType.LEBENSLAUF,
      text: "Lebenslauf",
      visibility: false,
      reference: null
    },
    ANSCHREIBEN: {
      type: DocumentType.ANSCHREIBEN,
      text: "Anschreiben",
      visibility: true,
      reference: {name: "wasd"}
    }
  }

  created(): void {
    this.store.$subscribe((state) => {
      //iwi ist es nicht möglich auf den state parameter zuzugreifen
      this.handleDocument(this.store.$state.documents.at(-1))
      this.redirectDocumentUploadFinished()
    })
    this.emitter.on('delete-declined', () => {
      this.deleteItem.visibility = false
    })
    this.emitter.on('delete-accepted', () => {
      this.deleteDocumentAccepted()
    })
  }

  mounted() : void {
    DocumentChecklistService.getFiles()
  }

  private handleDocument(document: DocumentDto): void {
    Object.keys(this.documents).forEach((key) => {
      if (document.documentType === key) {
        this.documents[key].visibility = true
        this.documents[key].reference = document
      }
    });
  }

  private redirectDocumentUploadFinished(): void {
    if (Object.values(this.documents).every((val) => val === true)) {
      console.log("redirect")
    }
  }

  private toggleDeleteDocument(document): void {
    this.deleteItem.visibility = true
    this.deleteItem.item = document
  }

  private deleteDocumentAccepted() : void{
    this.deleteItem.visibility = false
  }

}
</script>
<template>
  <v-container>
    <DeleteDialog
        :visibility="deleteItem.visibility"
        :delete-item="deleteItem.item"
        :delete-text="deleteItem.text"
    />
    <v-card>
      <v-card-title>
        Hochgeladene Dokumente
      </v-card-title>
      <v-card-item>
        <div v-for="document in documents" :key="document">
          <v-row>
            <v-col>
              <v-checkbox disabled v-model="document.visibility" :label="document.text"/>
            </v-col>
            <v-col>
              <div v-if="document.reference">
                {{ document.reference.name }}
                <div>
                  <svg @click="toggleDeleteDocument(document)" xmlns="http://www.w3.org/2000/svg" height="25" width="25"
                       viewBox="0 0 24 24">
                    <title>trash-can</title>
                    <path
                        d="M9,3V4H4V6H5V19A2,2 0 0,0 7,21H17A2,2 0 0,0 19,19V6H20V4H15V3H9M9,8H11V17H9V8M13,8H15V17H13V8Z"/>
                  </svg>
                </div>
              </div>
            </v-col>
          </v-row>
        </div>
      </v-card-item>
    </v-card>
  </v-container>
</template>
<script lang="ts">
import {Options, Vue} from 'vue-class-component'
import DocumentUploadComponent from "./DocumentUploadComponent.vue";
import DocumentChecklistComponent from "../checklist/DocumentChecklistComponent.vue";

@Options({
  components: {
    DocumentChecklistComponent,
    DocumentUploadComponent
  },
})
export default class DocumentUploadView extends Vue {

}
</script>
<template>
    <v-app>
        <document-upload-component></document-upload-component>
        <document-checklist-component></document-checklist-component>
    </v-app>
</template>
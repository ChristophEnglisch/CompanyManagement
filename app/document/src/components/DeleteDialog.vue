<script lang="ts">
import {Options, Vue} from "vue-class-component";

@Options({
  props: {
    visibility: Boolean,
    deleteText: String,
    deleteItem: Object
  }
})
export default class DeleteDialog extends Vue {

  private acceptDelete() : void {
    this.emitter.emit('delete-accepted', this.deleteItem)
  }

  private declinedDelete() : void {
    this.emitter.emit('delete-declined')
    this.visibilty = false
  }

}
</script>
<template>
  <v-dialog
      v-model="visibility"
      width="500"
  >
    <v-card>
      <v-card-text>{{ deleteText }}</v-card-text>
      <v-card-actions>
        <v-btn @click="declinedDelete">
          abbrechen
        </v-btn>
        <v-btn @click="acceptDelete">
          löschen
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>
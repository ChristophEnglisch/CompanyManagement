<template>
    <v-container>
        <v-alert v-model="deposed" type="success">
             Verifizierungsmail wurde versendet, überprüfen Sie ihr Postfach und bestätigen Sie ihre Mail.
        </v-alert>
        <v-card>
            <v-card-title>
                Persönliche Informationen
            </v-card-title>
            <v-card-item>
                <v-text-field v-model="personalInformation.email" label="E-Mail"></v-text-field>
                <v-text-field v-model="personalInformation.firstName" label="Vorname"></v-text-field>
                <v-text-field v-model="personalInformation.lastName" label="Nachname"></v-text-field>
            </v-card-item>
            <v-card-actions>
                <v-btn block :onclick="deposePersonalInformation">einsenden</v-btn>
            </v-card-actions>
        </v-card>

    </v-container>
</template>
<script lang="ts">
import {Vue} from 'vue-class-component'
import PersonalInformationDto from "@/person/PersonalInformationDto";
import PersonalInformationService from "@/person/PersonalInformationService";

export default class PersonalInformationComponent extends Vue {

    private deposed = false;

    private personalInformation: PersonalInformationDto = {
        email: '',
        firstName: '',
        lastName: ''
    }

    private deposePersonalInformation(): void {
        PersonalInformationService.deposePersonalInformation(this.personalInformation)
        this.deposed = true
    }
}
</script>
<template>
  <personal-information/>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import PersonalInformation from '@/person/PersonalInformationComponent.vue';

export default defineComponent({
    name: 'PersonalInformationView',
    components: {
        PersonalInformation: PersonalInformation,
    },
});

</script>

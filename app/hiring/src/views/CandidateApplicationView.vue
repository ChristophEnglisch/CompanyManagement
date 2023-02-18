<template>
  <candidate-application/>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import CandidateApplication from '../components/CandidateApplication.vue';

export default defineComponent({
  name: 'CandidateApplicationView',
  components: {
    candidateApplication: CandidateApplication,
  },
});
</script>

<script setup lang="ts">

import TextBlock from "@/components/TextBlock.vue";
import ErrorBlock from "@/components/ErrorBlock.vue";
</script>

<template>
  <div class="container">
    <ErrorBlock>
      <h1>Oopsie</h1>
      <p>Something went wrong</p>
    </ErrorBlock>
  </div>

</template>

<style scoped>

.text-block {
  border-left: solid 4px red;
}

</style>

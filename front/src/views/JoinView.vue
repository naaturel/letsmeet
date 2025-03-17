<script setup lang="ts">

import TextBlock from "@/components/TextBlock.vue";
import Button from "@/components/Button.vue";
import InputField from "@/components/InputField.vue";
</script>

<template>

  <div class="container">
    <TextBlock>
      <h1>Join an <span class="colored-text">event</span></h1>
    </TextBlock>

    <div class="actions-group">
      <InputField/>
      <Button description="Go for it"></Button>
    </div>

  </div>

</template>

<style scoped>

</style>

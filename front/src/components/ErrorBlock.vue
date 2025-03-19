<script setup lang="ts">

import TextBlock from "@/components/TextBlock.vue";
</script>

<template>
  <TextBlock>
    <slot></slot>
  </TextBlock>
</template>

<style scoped>
.text-block {
  border-left: solid 4px red;
}
</style>

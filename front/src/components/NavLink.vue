<script setup lang="ts">

import Button from "@/components/Button.vue";

const props = defineProps<{
  path: string;
  description: string;
}>();

</script>

<template>
  <router-link :to=path>
    <Button :description="description"/>
  </router-link>
</template>

<style scoped>

</style>

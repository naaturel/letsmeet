<script setup lang="ts">

import Button from "@/components/Button.vue";

const props = defineProps<{
  path: string;
  description: string;
}>();

</script>

<template>
  <div class="nav-link">
    <router-link :to=path >
      <Button :description="description"/>
    </router-link>
  </div>
</template>

<style scoped>

</style>

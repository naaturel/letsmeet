<script setup lang="ts">

  const props = defineProps<{
    description: string;
    action?: Function;
  }>();

</script>

<template>
  <div @click="action ? action : null" class="button">{{ description }}</div>
</template>

<style scoped>

.button {
  height: 100%;
  width: 100%;
  color: var(--primary-color);
  text-align: center;
  align-content: center;

  border-radius: var(--radius);
  background-color: var(--secondary-color);
  word-break: break-word;
}

.button:hover
{
  transform: scale(1.1);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
}

</style>

<script setup lang="ts">

  const props = defineProps<{
    description: string;
  }>();

</script>

<template>
  <div class="button">{{ description }}</div>
</template>

<style scoped>

.button {
  color: var(--primary-color);
  text-align: center;
  align-content: center;

  border-radius: var(--radius);
  background-color: var(--secondary-color);
  word-break: break-word;
  min-height: 7vh;
}

.button:hover
{
  transform: scale(1.1);
  background-color: var(--header-color);
  filter: drop-shadow(0px 4px 4px rgba(0, 0, 0, 0.25));
}

</style>

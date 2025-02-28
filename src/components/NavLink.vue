<script setup lang="ts">
</script>

<template>
  <router-link to="/create"><div class="button">Create an event</div></router-link>
</template>

<style scoped>

.button {
  color: var(--primary-color);
  text-align: center;
  align-content: center;
  min-width: 15vw;
  min-height: 7vh;
  border-radius: var(--radius);
  background-color: var(--secondary-color);
}

.button:hover
{
  background-color: rgba(255, 255, 255, 0.8);
}
</style>

<script setup lang="ts">

const props = defineProps<{
  path: string;
  description: string;
}>();

</script>

<template>
  <router-link :to=path><div class="button">{{ description }}</div></router-link>
</template>

<style scoped>

@media screen and (min-width: 801px) {
  .button {
    width: 15vw;
    min-width: 15vw;
  }
}

@media screen and (max-width: 800px) {
  .button {
    width: 50vw;
    min-width: 50vw;
  }

}

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

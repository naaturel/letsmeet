<script setup lang="ts">

</script>

<template>
  <div class="text-block">
    <slot></slot>
  </div>
</template>

<style scoped>

.text-block {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  padding: 0 1vw 0 1vw;
}

.text-block {
  flex-direction: column;
  padding: 30px;
  min-width: 250px;
}

.text-block {
  justify-content: start;
  word-break: break-word;
  height: fit-content;

  border-radius: var(--radius);
  border-left: solid 4px;
  background: rgb(239, 239, 239);
}

</style>

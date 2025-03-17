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
  flex-direction: column;

  justify-content: center;
  align-items: center;

  word-break: break-word;
  height: fit-content;

  border-radius: var(--radius);
  border-left: solid 4px;
  background: rgb(239, 239, 239);
}

@media screen and (min-width: 1001px) {
  .text-block {
    padding: 30px;
    width: 50%;
  }
}

@media screen and (max-width: 1000px) {
  .text-block {
    padding: 10px;
  }
}
</style>

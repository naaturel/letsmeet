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
  /*justify-content: start;*/

  word-break: break-word;
  height: fit-content;

  border-radius: var(--radius);
  border-left: solid 4px;
  background: rgb(239, 239, 239);
}


@media screen and (max-width: 800px) {
  .text-block {
    padding: 5px 15px 5px 15px;
  }
}

@media screen and (min-width: 801px) {
  .text-block {
    padding: 10px 30px 10px 30px;
  }
}

</style>

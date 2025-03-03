<script setup lang="ts">

import Calendar from "@/components/Calendar.vue";
import TextBlock from "@/components/TextBlock.vue";
</script>

<template>
  <div class="container">
    <TextBlock class="text-block">
      <h1>Create an <span class="colored-text">event</span></h1>
    </TextBlock>
    <Calendar class="calendar" />
  </div>
</template>

<style scoped>

.container
{
  display: flex;
  flex-direction: row;
  width: 80%;
  gap: 10vw;
}

.text-block
{
  width: 50%;
}

.calendar
{
  width: 45%;
}

</style>

<script setup lang="ts">

import Calendar from "@/components/Calendar.vue";
import TextBlock from "@/components/TextBlock.vue";
import NavLink from "@/components/NavLink.vue";
import InputField from "@/components/InputField.vue";
import {eventStore} from "@/stores/EventStore.ts";

const store = eventStore();

</script>

<template>

  <div class="container">
    <TextBlock class="title">
      <h1>Create an <span class="colored-text">event</span></h1>
    </TextBlock>
    <div class="event-form">
      <InputField placeholder="Event name" @update:value="(newValue) => { store.setName(newValue) }"/>
      <Calendar class="calendar"/>
      <NavLink name="Create" description="Create" class="create-button"></NavLink>
    </div>
  </div>

</template>

<style scoped>

.container
{
  width: 80%;
  gap: 10vw;
}

.event-form {
  display: flex;
  flex-direction: column;
  width: 45%;
  gap: 20px;
}

.input-field{
  height: 50px;
  font-size: calc(0.4 * 50px);
  min-height: 50px;
}

.nav-link
{
  width: 50%;
  height: 50px;
  min-height: 50px;
}

/* MEDIA QUERIES */
@media screen and (min-width: 1001px) {

  .title {
    width: 50%;
  }

  .title h1
  {
    font-size: 4rem;
  }

  .calendar {
    width: 100%;
    min-width: 100%;
  }

  .input-field
  {
    width: 50%;
  }

}

@media screen and (max-width: 1000px) {

  .title, .event-form, .input-field, .nav-link {
    width: 100%;
  }

  .title {
    height: fit-content;
  }
}

</style>

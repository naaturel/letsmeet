<script setup lang="ts">

import Calendar from "@/components/Calendar.vue";
import TextBlock from "@/components/TextBlock.vue";
import InputField from "@/components/InputField.vue";
import {eventCreationStore} from "@/stores/EventCreationStore.ts";
import Button from "@/components/Button.vue";
import {ref} from "vue";
import {useRouter} from "vue-router";
import {API_PATHS} from "@/config/ApiConfig.ts";

const router = useRouter();
const store = eventCreationStore();
const errorMessage = ref("");

async function createEvent() {
  if(!store.event.name){
    displayError("Please enter a valid name.", getNameField());
    return;
  }
  if(store.event.dates.size == 0){
    displayError("Please select at least one date", getCalendar());
    return;
  }

  let createdToken = await store.createEvent();
  await router.push({name: API_PATHS.NAMES.EVENTS, params: {token: createdToken}});
}

function updateName(value: string) {
  resetError(getNameField());
  store.setName(value);
}

function updateDates(value: number) {
  resetError(getCalendar());
  store.toggleDate(value)
}

function displayError(message: string, target : HTMLElement) {
  target.style.border = "2px solid red";
  errorMessage.value = message;
}

function resetError(target : HTMLElement){
  target.style.border = "2px solid black";
  errorMessage.value = "";
}

function getNameField() : HTMLElement {
  return document.getElementsByClassName("input-field")[0] as HTMLElement;
}

function getCalendar() : HTMLElement {
  return document.getElementsByClassName("calendar-container")[0] as HTMLElement;
}

</script>

<template>

  <div class="container">
    <TextBlock class="title">
      <h1>Create an <span class="colored-text">event</span></h1>
    </TextBlock>
    <div class="event-form">
      <div class="whatever-the-fuck-this-is">
        <InputField placeholder="Event name" @update:value="(newValue) => { updateName(newValue) }"/>
        <div>{{ errorMessage }}</div>
      </div>
      <Calendar class="calendar" @update:value="(newValue) => { updateDates(newValue) }"/>
      <Button @click="createEvent" description="Create" class="create-button" ></Button>
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

.button
{
  width: 50%;
  height: 50px;
  min-height: 50px;
}

.whatever-the-fuck-this-is
{
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
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

  .title, .event-form, .input-field, .button {
    width: 100%;
  }

  .title {
    height: fit-content;
  }
}

</style>

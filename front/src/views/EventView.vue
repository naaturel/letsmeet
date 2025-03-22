<script setup lang="ts">
import {eventCreationStore} from "@/stores/EventCreationStore.ts";
import {onBeforeMount, ref} from "vue";
import {useRoute} from "vue-router";
import {DateHelper} from "@/helpers/DateHelper.ts";
import {Event} from "@/models/Event.ts";
import ErrorBlock from "@/components/ErrorBlock.vue";
import AttendanceGraph from "@/components/AttendanceGraph.vue";
import Calendar from "@/components/Calendar.vue";

const route = useRoute();
const store = eventCreationStore();
const token = extractToken();
let event = ref<Event | undefined>();

onBeforeMount(async () => {
  try{
    await store.fetch(token);
    event.value = store.getEvent;
  } catch (error){
    console.error(error);
    event.value = undefined;
  }
})

function extractToken() : string {
  return Array.isArray(route.params.token) ? route.params.token[0] : route.params.token;
}


</script>

<template>
    <div v-if="!event" class="container error-block">
      <ErrorBlock>
        <h1>This event does not exist</h1>
      </ErrorBlock>
    </div>
    <div v-else class="container">
      <AttendanceGraph :event="event" />
      <Calendar/>
    </div>
</template>

<style scoped>
.error-block{
  width: 100%;
}

@media screen and (min-width: 1001px) {
  .attendance-graph
  {
    width: 50%;
    height: 50%;
  }

}

@media screen and (max-width: 1000px) {
  .attendance-graph
  {
    width: 500px;
    height: 500px;
  }

}


</style>

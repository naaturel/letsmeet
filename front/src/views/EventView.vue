<script setup lang="ts">
import {eventStore} from "@/stores/EventStore.ts";
import {onMounted} from "vue";
import {useRoute} from "vue-router";
import {DateHelper} from "../helpers/DateHelper.ts";

const route = useRoute();
const store = eventStore();
const token = extractToken();

onMounted(async () => {
  await store.fetch(token);
})

function extractToken() : string {
  return Array.isArray(route.params.token) ? route.params.token[0] : route.params.token;
}

function attendeesByDates(){

}

function formatDate(timestamp : number) : String{
  let date = DateHelper.toDate(timestamp)
  return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
}

</script>

<template>

  Name : {{ store.event.name }} <br>
  attendees :
  <div v-for="(p) in store.event.attendees" >
    {{ p.name  }}
    <div v-for="(d) in p.dates">
      {{ formatDate(d.value) }}
    </div>
  </div>
</template>

<style scoped>

</style>

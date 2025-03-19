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

</script>

<template>

  Name : {{ store.event.name }}
  Participants :
  <div v-for="(p) in store.event.participants" >
    {{ p.name  }}
    <div v-for="(d) in p.dates">
      {{ DateHelper.toDate(d.value) }}
    </div>
  </div>
</template>

<style scoped>

</style>

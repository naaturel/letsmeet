<script setup lang="ts">
import {eventStore} from "@/stores/EventStore.ts";
import {onBeforeMount, ref} from "vue";
import {useRoute} from "vue-router";
import {DateHelper} from "@/helpers/DateHelper.ts";
import {Event} from "@/models/Event.ts";
import ErrorBlock from "@/components/ErrorBlock.vue";

const route = useRoute();
const store = eventStore();
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

function formatDate(timestamp : number) : String{
  let date = DateHelper.toDate(timestamp);
  return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
}

</script>

<template>
  <div class="container">

    <div v-if="!event" class="error-block">
      <ErrorBlock>
        <h1>This event does not exist</h1>
      </ErrorBlock>
    </div>

    <div v-else>
      Name : {{ event.getName() }} <br>
      <div v-for="(timestamp) in event.getGroups().keys()" >
        {{ formatDate(timestamp)  }}
        <div v-for="(attendee) in event.getGroups().get(timestamp)">
          {{ attendee }}
        </div>
        =================
      </div>
    </div>

  </div>

</template>

<style scoped>
.error-block{
  width: 100%;
}
</style>

<script setup lang="ts">

import Button from "@/components/Button.vue";
import {useRouter} from "vue-router";

const router = useRouter();

const props = defineProps({
  description: {
    type: [String],
    required: true
  },
  name: {
    type: [String],
    required: true
  },
  params: {
    type: [Object],
    required: false
  }});

function browse() : void {
  console.log({ name: props.name, params: props.params});
  router.push({ name: props.name, params: props.params});
}

</script>

<template>
  <div class="nav-link" @click="browse">
      <Button :description="description"/>
  </div>
</template>

<style scoped>

</style>

<script setup lang="ts">

import {onMounted} from "vue";
import {Chart, type ChartItem} from "chart.js/auto";
import {Event} from "@/models/Event.ts";


const props = defineProps<{
  event: Event;
}>();

let data = props.event.getDates();

onMounted(() => {
  draw()
  console.log(props.event);
})

function draw() {
  const ctx = document.getElementById('myChart');
  if(!ctx) return;

  new Chart(ctx as ChartItem, {
    type: 'doughnut',
    data : {
      labels: data.dates,
      datasets: [{
        label: 'Attendances',
        data: data.attendances,

        hoverOffset: 4
      }]
    }
  });
}



</script>

<template>
  <div class="attendance-graph">
    <canvas id="myChart"></canvas>
  </div>
</template>

<style scoped>
canvas {
  width: 100%;
  height: 100%;
}
</style>

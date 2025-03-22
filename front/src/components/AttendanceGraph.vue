<script setup lang="ts">

import {onMounted, ref} from "vue";
import {Event} from "@/models/Event.ts";
import {AttendanceGraph} from "@/models/AttendanceGraph.ts";
import type {Attendee} from "@/models/Attendee.ts";

const props = defineProps<{
  event: Event;
}>();

let graph = new AttendanceGraph(props.event);

onMounted(() => {
  render();
})

function render() : void{
  let container = queryContainer();
  for (let date of graph.getDates()) {
    let attendees: Attendee[] = graph.getAttendees(date);
    let bar = addBar(container);
    setBarSize(bar, graph.getRatio(date));
    setBarTooltip(bar, graph.getAttendees(date).length);
  }
}

function addBar(container : HTMLElement) : HTMLElement {
  let bar = document.createElement("div");
  bar.classList.add("bar");
  container.appendChild(bar);
  return bar;
}

function setBarSize(bar : HTMLElement, ratio : number) : void{
  console.log(ratio);
  bar.style.width = `${ratio*100}%`;
}

function setBarTooltip(bar : HTMLElement, attendeesCount : number) : void{
  let tooltip = document.createElement('div');
  tooltip.classList.add('tooltip');
  tooltip.innerText = attendeesCount.toString();

  tooltip.style.position = 'absolute';
  tooltip.style.visibility = 'hidden'; // Initially hidden
  tooltip.style.backgroundColor = 'black';
  tooltip.style.color = 'white';
  tooltip.style.padding = '5px';
  tooltip.style.borderRadius = '5px';

  bar.addEventListener('mouseenter', function() {
    document.body.appendChild(tooltip);
    const rect = bar.getBoundingClientRect();
    tooltip.style.left = `${rect.left + window.scrollX}px`;
    tooltip.style.top = `${rect.top + window.scrollY - tooltip.offsetHeight - 5}px`;
    tooltip.style.visibility = 'visible';
  });

  bar.addEventListener('mouseleave', function() {
    tooltip.style.visibility = 'hidden';
    tooltip.remove();
  });
}

function queryContainer() : HTMLElement {
  return document.getElementsByClassName("graph")[0] as HTMLElement;
}

</script>

<template>
  <div class="attendance-graph">
    <h2>{{event.getName()}}</h2>
    <div class="graph"></div>
  </div>
</template>

<style scoped>
.graph {
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  gap: 10px;
  border-left: solid 1px black;
  border-bottom: solid 1px black;
}

::v-deep(.bar)
{
  height : 30px;
  border : solid 1px black;
  background-color: var(--secondary-color);
  flex-grow: 1;
}

::v-deep(.bar):hover
{
  transform: scale(1.1);
}

.tooltip {
  position: absolute;
  background-color: black;
  padding: 5px;
  border-radius: 5px;
  visibility: hidden;
  opacity: 0;
  transition: opacity 0.3s;
}

.tooltip.visible {
  visibility: visible;
  opacity: 1;
}

</style>

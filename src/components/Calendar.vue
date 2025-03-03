<script setup lang="ts">
  import ArrowRight from "@/assets/arrow-right.svg"
  import ArrowLeft from "@/assets/arrow-left.svg";

  import {ref, onMounted} from "vue";
  import {Calendar} from "@/models/Calendar.ts";

  const calendar = new Calendar();

  const monthYear = ref("");
  const dates = ref([]);

  onMounted(() => {
    setupCalendar();
  })

  function clickPrev(){
    dates.value = calendar.datesOfPrevMonth();
    updateMonth();
  }

  function clickNext(){
    dates.value = calendar.datesOfNextMonth();
    updateMonth();
  }

  function setupCalendar(){
    dates.value = calendar.datesOfToday();
    updateMonth();
  }

  function updateMonth(){
    monthYear.value = calendar.getDate();
  }

</script>

<template>
  <div class="calendar-container">
    <div class="month-picker">
      <div>{{ monthYear }}</div>
      <div class="arrows">
        <div @click="clickPrev" class="prevMonth"><ArrowLeft class="arrow-left" /></div>
        <div @click="clickNext" class="nextMonth"><ArrowRight class="arrow-right" /></div>
      </div>
    </div>

    <div class="day-names">
      <div>M</div>
      <div>T</div>
      <div>W</div>
      <div>T</div>
      <div>F</div>
      <div>S</div>
      <div>S</div>
    </div>

    <div class="day-picker">
      <div v-for="day in dates" :key="day" :class="{'item': day !== null}">
        {{ day }}
      </div>
    </div>
  </div>
</template>

<style scoped>

.calendar-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  border: solid 2px;
  border-radius: var(--radius);
  padding: 0 20px 20px 20px;
}

.month-picker, .day-picker, .day-names {
  justify-items: center;
}

.month-picker {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  border-bottom:solid 1px;
  padding: 20px;
}

.arrows {
  display: flex;
  gap: 10px;
}

.arrow-left, .arrow-right {
  width: 30px;
  border-radius: var(--radius);
  padding: 5px 7px 5px 7px;
}

.arrow-left:hover, .arrow-right:hover {
  transform: scale(1.2);
  background-color: rgb(239,239,239);
}

.day-picker, .day-names {
  display: grid;
  grid-template-columns: repeat(7, 2fr);
  row-gap: 20px;
  width: 100%;
}

.day-names {
  padding: 20px 0 20px 0;
}

.item
{
  text-align: center;
  width: 90%;
  min-width: 30px;
  height: 100%;
  border: solid 1px;
  border-radius: 5px;
}

.item:hover
{
  transform: scale(1.1);
  background-color: var(--secondary-color);
}

</style>

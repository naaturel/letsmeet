<script setup lang="ts">
  import ArrowRight from "@/assets/svg/arrow-right.svg"
  import ArrowLeft from "@/assets/svg/arrow-left.svg";
  import {ref, onMounted, watch} from "vue";
  import { datePickerStore } from "@/stores/CalendarStore.ts";
  import { Calendar } from "@/models/Calendar.ts";

  const calendar = new Calendar();
  const datePicker = datePickerStore();
  const monthYear = ref("");
  const dates = ref([] as (number | null)[]);
  const selectedDays = ref(new Map<string, Date>());

  onMounted(() => {
    setupCalendar();
  })

  watch(selectedDays, (newValue) => {
    let dates = Array.from(newValue.values())
    datePicker.update(dates);
  }, { deep: true });

  function selectDay(event : Event, day : number | null){
    if(!(event.target instanceof HTMLElement) || day == null) return;
    calendar.setDay(day);
    toggleSelectedDay(event.target.id,  calendar.getDate());
    highlightSelectedDay(event.target);
  }

  function toggleSelectedDay(id : string, date : Date) : void {
    if(selectedDays.value.has(id)){
      selectedDays.value.delete(id);
    } else {
      selectedDays.value.set(id, date);
    }
  }

  function highlightSelectedDay(element : HTMLElement){
    element.classList.toggle("item-selected");
  }

  function setupCalendar(){
    dates.value = calendar.datesOfCurrentMonth();
    updateMonth();
  }

  function clickPrev(){
    dates.value = calendar.datesOfPrevMonth();
    updateMonth();
  }

  function clickNext(){
    dates.value = calendar.datesOfNextMonth();
    updateMonth();
  }

  function updateMonth(){
    monthYear.value = calendar.getMonthYear();
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

    <!--Elements are not recreated ? Does only the id change ? -->
    <!--Keep track of all selected ids and update view when month is update ? -->
    <div class="day-picker">
      <div v-on:click="selectDay($event, day)"
           v-for  ="(day) in dates"
           :id    ="day !== null ? `${day}-${monthYear}` : undefined"
           :class ="{
             'item': day !== null,
             'item-selected' : selectedDays.has(`${day}-${monthYear}`)
           }">
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
  grid-template-columns: repeat(7, 1fr);
  row-gap: 20px;
  width: 100%;
}

.day-picker {
  grid-template-rows: repeat(6, 1fr);
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
  user-select: none;
}

.item-selected
{
  background-color: var(--secondary-color);
}

.item:hover
{
  transform: scale(1.1);
}

</style>

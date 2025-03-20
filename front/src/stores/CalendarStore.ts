import { defineStore } from 'pinia'
import {EventDate} from "@/models/EventDate.ts";

export const datePickerStore = defineStore('datePicker', {
  state: () => {
    return { dates: [] as EventDate[] }
  },
  getters: {
    value: (state) : EventDate[] => state.dates as EventDate[],
  },
  actions: {
    getValue(){
      return this.dates;
    },
    update(dates : Date[]) : void {
      this.dates = dates.map(date => new EventDate(date));
    },
    clear() : void {
      this.dates = [] as EventDate[];
    },
  },
})

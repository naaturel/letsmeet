import { defineStore } from 'pinia'
import {TimeStamp} from "@/models/TimeStamp.ts";

export const datePickerStore = defineStore('datePicker', {
  state: () => {
    return { dates: [] as TimeStamp[] }
  },
  actions: {
    update(dates : Date[]) {
      this.dates = dates.map(date => new TimeStamp(date));
      console.log(this.dates);
    },
  },
})

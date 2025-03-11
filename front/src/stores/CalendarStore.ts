import { defineStore } from 'pinia'
import {TimeStamp} from "@/models/TimeStamp.ts";

export const datePickerStore = defineStore('datePicker', {
  state: () => {
    return { dates: [] as TimeStamp[] }
  },
  getters: {
    value: (state) : TimeStamp[] => state.dates as TimeStamp[],
  },
  actions: {
    getValue(){
      return this.dates;
    },
    update(dates : Date[]) : void {
      this.dates = dates.map(date => new TimeStamp(date));
    },
    clear() : void {
      this.dates = [] as TimeStamp[];
    },
  },
})

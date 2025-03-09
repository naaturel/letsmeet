import { defineStore } from 'pinia'

export const datePickerStore = defineStore('datePicker', {
  state: () => {
    return { from: new Date(), to: new Date() }
  },
  actions: {
    select(date : Date) {
      this.from = date < this.from ? date : this.from;
      this.to =   date > this.to   ? date : this.to;
    },
  },
})

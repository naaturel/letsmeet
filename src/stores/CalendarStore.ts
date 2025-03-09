import { defineStore } from 'pinia'
import { ArrayHelper} from "@/helpers/ArrayHelper.ts";

export const datePickerStore = defineStore('datePicker', {
  state: () => {
    return { dates: [] as number[] }
  },
  actions: {
    select(date : Date) {
      toggleElement(this.dates, date.getTime());
      console.log(this.dates);
    },
  },
})

function toggleElement(arr : any[], element:any) : void {
  let index = ArrayHelper.indexOf(arr, element);
  if (index < 0) {
    arr.push(element);
  } else {
    arr.splice(index, 1);
  }
}

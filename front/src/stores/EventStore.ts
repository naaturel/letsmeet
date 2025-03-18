import { defineStore } from 'pinia'
import {EventRequests} from "@/requests/EventRequests.ts";

const requests = new EventRequests();

export const eventStore = defineStore('datePicker', {
  state: () => {
    return {
      event: Event
    }
  },

  actions: {
    fetch: (token : string) => {
      requests.queryEvent(token);
    }
  },
})

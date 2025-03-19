import {defineStore} from 'pinia'
import {EventRequests} from "@/requests/EventRequests.ts";
import type {EventDto} from "@/dto/EventDto.ts";
import type {EventState} from "@/models/Event.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";
import type {AttendeeState} from "@/models/Attendee.ts";
import type {TimeStamp, TimeStampState} from "@/models/TimeStamp.ts";
import type {TimeStampDto} from "@/dto/TimeStampDto.ts";

const requests = new EventRequests();

export const eventStore = defineStore('eventStore', {
  state: (): {event : EventState} => {
    return {
      event : {
        name: "",
        token: "",
        attendees: [] as AttendeeState[]
      }};
  },
  getters : {
    getEvent()  {
    }
  },
  actions: {
    async fetch(token: string): Promise<void> {
        try{
          let data : EventDto | void = await requests.queryEvent(token);
          if(!data) throw new Error("No event found");
          this.event.name = data.name;
          this.event.token = data.token;

          this.event.attendees = data.attendees.map((p: AttendeeDto) => ({
            name: p.name,
            dates: p.dates.map((date: TimeStampDto) => ({
              value: date.timestamp
            })) as TimeStampState[]
          }));
        } catch (error) {
          console.error("Unable to fetch. " + error);
        }
    },
  },
});

import {defineStore} from 'pinia'
import {EventRequests} from "@/requests/EventRequests.ts";
import type {EventDto} from "@/dto/EventDto.ts";
import {Event, type EventState} from "@/models/Event.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";
import {Attendee, type AttendeeState} from "@/models/Attendee.ts";
import {TimeStamp, type TimeStampState} from "@/models/TimeStamp.ts";
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
    getEvent(state) : Event  {
      let attendees : Attendee[] = state.event.attendees.map((a : AttendeeState) => {
        let dates: TimeStamp[] = a.dates.map(d => new TimeStamp(new Date(d.value)))
        return new Attendee(a.name, dates);
      });
      return new Event(state.event.name.toString(), "", attendees);
    }
  },
  actions: {
    async fetch(token: string): Promise<void> {
        try{
          let data : EventDto | void = await requests.queryEvent(token);
          if(!data) throw new Error("No event found");
          this.event.name = data.name;
          this.event.token = data.token;

          this.event.attendees = data.attendees.map((a: AttendeeDto) => ({
            name: a.name,
            dates: a.dates.map((date: TimeStampDto) => ({
              value: date.timestamp
            })) as TimeStampState[]
          }));
        } catch (error) {
          console.error(error);
          throw new Error("Unable to fetch.");
        }
    },
  },
});

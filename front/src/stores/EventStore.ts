import {defineStore} from 'pinia'
import {EventRequests} from "@/requests/EventRequests.ts";
import {EventDto} from "@/dto/EventDto.ts";
import {Event, type EventState} from "@/models/Event.ts";
import {Attendee, type AttendeeState} from "@/models/Attendee.ts";
import {EventDate, type EventDateState} from "@/models/EventDate.ts";

const requests = new EventRequests();

function mapToDto() : EventDto{
  return new EventDto("", "", new Map());
}

function mapToModel(state : EventState) : Event{
  let dates: Map<number, Attendee[]> = new Map();
  for (let [date, attendeesState] of state.dates.entries()) {
    let attendees : Attendee[] = attendeesState.map(attendee => {
      return new Attendee(attendee.name);
    })
    dates.set(date.value, attendees);
  }
  return new Event(state.name, state.token, dates);
}

function mapToState(dto : EventDto) : EventState {
  let event : EventState = {name : "", token : "", dates: new Map<EventDateState, AttendeeState[]>()};
  event.name = dto.name;
  event.token = dto.token;
  Object.entries(dto.dates).forEach(([key, attendees]) => {
    let dateState : EventDateState = { value: Number(key) };
    event.dates.set(dateState, attendees);
  });
  return event;
}

export const eventStore = defineStore('eventStore', {
  state: (): {event : EventState} => {
    return {
      event : {
        name: "",
        token: "",
        dates: new Map<EventDateState, AttendeeState[]>()
      }};
  },
  getters : {
    getEvent(state) : Event  {
      return mapToModel(state.event);
    }
  },
  actions: {
    setName(name : string){
      this.event.name = name;
    },
    async fetch(token: string): Promise<void> {
        try{
          let data : EventDto | void = await requests.queryEvent(token);
          if(!data) throw new Error("No event found");
          this.event = mapToState(data);
        } catch (error) {
          console.error(error);
          throw new Error("Unable to fetch. " + error);
        }
    },
    async create(){
      let event = mapToDto();
      await requests.createEvent(event)
    }
  },
});

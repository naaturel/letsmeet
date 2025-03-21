import {defineStore} from 'pinia'
import {EventRequests} from "@/requests/EventRequests.ts";
import {EventDto} from "@/dto/EventDto.ts";
import {Event, type EventState} from "@/models/Event.ts";
import {Attendee, type AttendeeState} from "@/models/Attendee.ts";
import {AttendanceDto} from "@/dto/AttendanceDto.ts";
import {TimeStampDto} from "@/dto/TimeStampDto.ts";
import {AttendeeDto} from "@/dto/AttendeeDto.ts";

const requests = new EventRequests();

function mapToDto(state : EventState) : EventDto{
  let dates : AttendanceDto[] = [];
  for (let [date, attendeesState] of state.dates.entries()) {
    let attendance : AttendanceDto = new AttendanceDto(new TimeStampDto(new Date(date)), new AttendeeDto(""));
    dates.push(attendance);
  }
  return new EventDto(state.name, state.token, dates);
}

function mapToModel(state : EventState) : Event{
  let dates: Map<number, Attendee[]> = new Map();
  for (let [date, attendeesState] of state.dates.entries()) {
    let attendees : Attendee[] = attendeesState.map(attendee => {
      return new Attendee(attendee.name);
    })
    dates.set(date, attendees);
  }
  return new Event(state.name, state.token, dates);
}

function mapToState(dto : EventDto) : EventState {
  let event : EventState = { name : "", token : "", dates: new Map<number, AttendeeState[]>() };
  event.name = dto.name;
  event.token = dto.token;
  dto.attendances.forEach(attendance => {
    let timestamp = attendance.date.timestamp;
    let attendee = attendance.attendee;
    if(event.dates.has(timestamp)) {
      event.dates.get(timestamp)?.push({name : attendee.name});
    } else {
      event.dates.set(timestamp, [{name : attendee.name}]);
    }
  })
  return event;
}

export const eventCreationStore = defineStore('eventStore', {
  state: (): {event : EventState} => {
    return {
      event : {
        name: "",
        token: "",
        dates: new Map<number, AttendeeState[]>()
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
    addDate(timestamp : number){
      this.event.dates.set(timestamp, []);
    },
    removeDate(timestamp : number){
      this.event.dates.delete(timestamp);
    },
    addAttendee(timestamp : number, name : string){
      let dates :Map<number, AttendeeState[]> = this.event.dates;
      if(dates.has(timestamp)){
        dates.get(timestamp)?.push({name : name});
      } else {
        let attendees : AttendeeState[] = [{name : name}];
        dates.set(timestamp, attendees);
      }
    },
    toggleDate(timestamp : number){
      let dates :Map<number, AttendeeState[]> = this.event.dates;
      if(dates.has(timestamp)){
        this.removeDate(timestamp);
      } else {
        this.addDate(timestamp);
      }
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
    async createEvent() : Promise<string> {
      try {
        let event = mapToDto(this.event);
        let res = await requests.createEvent(event)
        if(res) return res;
        throw new Error("Unable to create event");
      } catch (error){
        console.error(error);
        throw new Error("Unable to post. " + error);
      }
    }
  },
});

import type {Attendee, AttendeeState} from "@/models/Attendee.ts";
import type {EventDate, EventDateState} from "@/models/EventDate.ts";

export class Event {

  private name: string;
  private token: string;
  private dates: Map<number, Attendee[]>;

  public constructor(name: string, token: string, dates : Map<number, Attendee[]>) {
    this.name = name;
    this.token = token;
    this.dates = dates;
  }

  public getName() : string {
    return this.name;
  }

  public getToken() : string {
    return this.token;
  }

  public getDates() : Map<number, Attendee[]> {
    return this.dates;
  }
}

export interface EventState {
  name : string
  token : string
  dates: Map<EventDateState, AttendeeState[]>;
}


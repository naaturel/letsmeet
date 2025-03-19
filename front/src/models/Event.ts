import type {Attendee, AttendeeState} from "@/models/Attendee.ts";

export class Event {

  private name: string;
  private token: string;
  private attendees: Attendee[];

  public constructor(name: string, token: string, attendees: Attendee[]) {
    this.name = name;
    this.token = token;
    this.attendees = attendees;
  }

  public getName() : string {
    return this.name;
  }

  public getToken() : string {
    return this.token;
  }

  public getAttendees() : Attendee[] {
    return this.attendees;
  }

}

export interface EventState {
  name : String
  token : String
  attendees: AttendeeState[];
}


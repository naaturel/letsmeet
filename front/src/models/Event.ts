import type {Attendee, AttendeeState} from "@/models/Attendee.ts";
import type {TimeStamp} from "@/models/TimeStamp.ts";

export class Event {

  private name: string;
  private token: string;
  private attendees: Attendee[];
  private groups : Map<number, string[]>;

  public constructor(name: string, token: string, attendees: Attendee[]) {
    this.name = name;
    this.token = token;
    this.attendees = attendees;
    this.groups = this.byDates();
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

  public getGroups() : Map<number, string[]> { return this.groups; }

  private byDates() : Map<number, string[]> {
    let res : Map<number, string[]> = new Map();
    this.attendees.forEach((attendee: Attendee) => {
      attendee.getDates().forEach((timeStamp: TimeStamp) => {
        let value : number = timeStamp.getValue();
        if(res.has(value)) {
          res.get(value)?.push(attendee.getName());
        } else {
          res.set(value, []);
          res.get(value)?.push(attendee.getName());
        }
      });
    });

    return res;
  }

}

export interface EventState {
  name : String
  token : String
  attendees: AttendeeState[];
}


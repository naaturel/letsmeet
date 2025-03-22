import type {Attendee, AttendeeState} from "@/models/Attendee.ts";
import {DateHelper} from "@/helpers/DateHelper.ts";

export class Event {

  private name: string;
  private token: string;
  private attendances: Map<number, Attendee[]>;

  public constructor(name: string, token: string, dates : Map<number, Attendee[]>) {
    this.name = name;
    this.token = token;
    this.attendances = dates;
  }

  public getName() : string {
    return this.name;
  }

  public getToken() : string {
    return this.token;
  }

  public getAttendances() : Map<number, Attendee[]> {
    return this.attendances;
  }

  public getDates() : {dates :  string[], attendances : number[]}{
    let dates = [];
    let attendances = [];
    for (let [date, attendees] of this.attendances.entries()) {
      dates.push(DateHelper.formatDate(date))
      attendances.push(attendees.length)
    }
    return {dates : dates, attendances : attendances};
  }
}

export interface EventState {
  name : string
  token : string
  dates: Map<number, AttendeeState[]>;
}


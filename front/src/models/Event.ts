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

  public getDates() : number[] {
    return Array.from(this.attendances.keys()).sort();
  }

  public getAttendees(date : number) : Attendee[] {
    if(this.attendances.has(date)){
      return this.attendances.get(date)!; //Fuck TS
    }
    return [];
  }

  public getMaxAttendees(){
    let max = 0;
    this.attendances.forEach(attendee => {
      if(attendee.length > max) max = attendee.length;
    })
    return max;
  }

}

export interface EventState {
  name : string
  token : string
  dates: Map<number, AttendeeState[]>;
}


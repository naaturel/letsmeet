import type {TimeStamp, TimeStampState} from "@/models/TimeStamp.ts";

export class Attendee {

  private name: string;
  private dates: TimeStamp[];

  public constructor(name: string, dates: TimeStamp[]) {
    this.name = name;
    this.dates = dates;
  }

  public getName() : string {
    return this.name;
  }

  public getDates() : TimeStamp[] {
    return this.dates;
  }
}

export interface AttendeeState {
  name : string
  dates : TimeStampState[]
}

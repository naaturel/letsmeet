import type {EventDate, EventDateState} from "@/models/EventDate.ts";

export class Attendee {

  private name: string;

  public constructor(name: string) {
    this.name = name;
  }

  public getName() : string {
    return this.name;
  }
}

export interface AttendeeState {
  name : string
}

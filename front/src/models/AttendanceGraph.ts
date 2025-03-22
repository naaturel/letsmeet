import type {Event} from "@/models/Event.ts";
import type {Attendee} from "@/models/Attendee.ts";

export class AttendanceGraph {

  private event: Event;
  private maxAttendees: number;

  public constructor(event : Event) {
    this.event = event;
    this.maxAttendees = event.getMaxAttendees();
    console.log(this.maxAttendees);
  }


  public getDates() : number[] {
    return Array.from(this.event.getDates());
  }

  public getAttendees(date : number): Attendee[] {
    return this.event.getAttendees(date);
  }

  public getRatio(date : number) : number{
    return (this.getAttendees(date).length / this.maxAttendees);
  }

}

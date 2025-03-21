import type {EventDate} from "@/models/EventDate.ts";
import type {Attendee} from "@/models/Attendee.ts";

export class Attendance {
  public date : EventDate
  public attendee : Attendee

  public constructor(date : EventDate, attendee : Attendee) {
    this.date = date;
    this.attendee = attendee;
  }
}

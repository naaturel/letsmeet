import type {Attendee} from "@/models/Attendee.ts";
import type {EventDate} from "@/models/EventDate.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";

export class EventDto {

  public name: string;
  public token: string;
  public dates : Map<EventDate, Attendee[]>

  public constructor(name: string, token: string, dates: Map<EventDate, Attendee[]>) {
    this.name = name;
    this.token = token;
    this.dates = dates;
  }

}

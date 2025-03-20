import type {Attendee} from "@/models/Attendee.ts";
import type {EventDate} from "@/models/EventDate.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";

export class EventDto {

  public name: string;
  public token: string;
  public dates : Map<number, AttendeeDto[]>

  public constructor(name: string, token: string, dates: Map<number, AttendeeDto[]>) {
    this.name = name;
    this.token = token;
    this.dates = dates;
  }

}

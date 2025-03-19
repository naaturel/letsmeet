import type {Attendee} from "@/models/Attendee.ts";
import type {TimeStamp} from "@/models/TimeStamp.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";

export class EventDto {

  public name: string;
  public token: string;
  public attendees: AttendeeDto[];

  public constructor(name: string, token: string, attendees: AttendeeDto[]) {
    this.name = name;
    this.token = token;
    this.attendees = attendees;
  }

}

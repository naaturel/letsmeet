import type {Attendee} from "@/models/Attendee.ts";
import type {EventDate} from "@/models/EventDate.ts";
import type {AttendeeDto} from "@/dto/AttendeeDto.ts";
import { AttendanceDto } from "./AttendanceDto.ts";

export class EventDto {

  public name: string;
  public token: string;
  public attendances : AttendanceDto[];

  public constructor(name: string, token: string, attendances : AttendanceDto[]) {
    this.name = name;
    this.token = token;
    this.attendances = attendances;
  }

}

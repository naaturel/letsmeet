import type {AttendeeDto} from "@/dto/AttendeeDto.ts";
import type {TimeStampDto} from "@/dto/TimeStampDto.ts";

export class AttendanceDto {

  public date : TimeStampDto
  public attendee : AttendeeDto

  public constructor(date : TimeStampDto, attendee : AttendeeDto) {
    this.date = date;
    this.attendee = attendee;
  }


}

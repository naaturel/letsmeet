import type {TimeStampDto} from "@/dto/TimeStampDto.ts";

export class AttendeeDto {

  public name: string;
  public dates: TimeStampDto[];

  public constructor(name: string, dates: TimeStampDto[]) {
    this.name = name;
    this.dates = dates;
  }
}


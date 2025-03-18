import type {TimeStamp} from "@/models/TimeStamp.ts";

export class Participant {

  private name: string;
  private dates: TimeStamp[];

  public constructor(name: string, dates: TimeStamp[]) {
    this.name = name;
    this.dates = dates;
  }

}

import type {TimeStamp, TimeStampState} from "@/models/TimeStamp.ts";

export class Participant {

  private name: string;
  private dates: TimeStamp[];

  public constructor(name: string, dates: TimeStamp[]) {
    this.name = name;
    this.dates = dates;
  }

  public getName(){
    return this.name;
  }

  public getDate() : TimeStamp[]{
    return this.dates;
  }
}

export interface ParticipantState {
  name : String
  dates : TimeStampState[]
}

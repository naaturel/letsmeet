import type {Participant, ParticipantState} from "@/models/Participant.ts";
import type {TimeStampState} from "@/models/TimeStamp.ts";

export class Event {

  private name: string;
  private token: string;
  private participants: Participant[];

  public constructor(name: string, token: string, participants: Participant[]) {
    this.name = name;
    this.token = token;
    this.participants = participants;
  }

  public getName() : string {
    return this.name;
  }

  public getToken() : string {
    return this.token;
  }

  public getParticipants() : Participant[] {
    return this.participants;
  }

}

export interface EventState {
  name : String
  token : String
  participants: ParticipantState[];
}


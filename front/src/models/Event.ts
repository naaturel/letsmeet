import type {Participant} from "@/models/Participant.ts";

export class Event {

  private name: string;
  private token: string;
  private participants: Participant[];

  public constructor(name: string, token: string, participants: Participant[]) {
    this.name = name;
    this.token = token;
    this.participants = participants;
  }

}

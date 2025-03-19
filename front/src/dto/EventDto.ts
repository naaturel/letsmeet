import type {Participant} from "@/models/Participant.ts";
import type {TimeStamp} from "@/models/TimeStamp.ts";
import type {ParticipantDto} from "@/dto/ParticipantDto.ts";

export class EventDto {

  public name: string;
  public token: string;
  public participants: ParticipantDto[];

  public constructor(name: string, token: string, participants: ParticipantDto[]) {
    this.name = name;
    this.token = token;
    this.participants = participants;
  }

}

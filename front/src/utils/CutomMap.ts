import type {TimeStamp} from "@/models/TimeStamp.ts";
import type {Attendee} from "@/models/Attendee.ts";

/**
 * I hate JavaScript and TypeScript with every single inch of my body
 */
export class CustomMap extends Map<TimeStamp, Attendee> {
  has(obj: TimeStamp): boolean {
    obj.getValue()
    return false;
  }
}

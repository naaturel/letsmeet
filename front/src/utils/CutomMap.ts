import type {EventDate} from "@/models/EventDate.ts";
import type {Attendee} from "@/models/Attendee.ts";

/**
 * I hate JavaScript and TypeScript with every single inch of my body
 */
export class CustomMap extends Map<EventDate, Attendee> {
  has(obj: EventDate): boolean {
    obj.getValue()
    return false;
  }
}

export abstract class DateHelper {

  public static toDate(timestamp: number): Date {
    return new Date(timestamp);
  }

}

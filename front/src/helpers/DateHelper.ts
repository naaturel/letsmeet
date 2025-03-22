export abstract class DateHelper {

  public static toDate(timestamp: number): Date {
    return new Date(timestamp);
  }

  public static formatDate(timestamp : number) : string{
    let date = DateHelper.toDate(timestamp);
    return `${date.getDate()}-${date.getMonth() + 1}-${date.getFullYear()}`;
  }

}

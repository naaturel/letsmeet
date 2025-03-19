export class TimeStampDto {

  public timestamp : number;

  public constructor(date : Date) {
    this.timestamp = date.getTime();
  }
}

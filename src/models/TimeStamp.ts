export class TimeStamp {

  private readonly value : number;

  public constructor(date : Date) {
    this.value = date.getTime();
  }

  public getValue() : number{
    return this.value;
  }
}

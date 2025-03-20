export class EventDate {

  private readonly value : number;

  public constructor(date : Date) {
    this.value = date.getTime();
  }

  public getValue() : number{
    return this.value;
  }

  public toString() {
    this.value.toString();
  }

}

export interface EventDateState {
  value : number;
}

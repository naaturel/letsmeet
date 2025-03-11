export class Calendar {

  private readonly monthsName : string[] = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
  ];
  private year : number;
  private month : number;
  private day : number;

  public constructor() {
    let date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth();
    this.day = date.getDay();
  }

  public getDate(): Date {
    return new Date(this.year, this.month, this.day);
  }

  public getMonthYear(){
    return `${this.monthsName[this.month]} ${this.year}`;
  }

  public setDay(day : number) { this.day = day; }

  public datesOfCurrentMonth(){
    return this.datesOf();
  }

  public datesOfNextMonth(){

    if(this.month+1 > 11){
      this.year += 1;
      this.month = 0;
    } else {
      this.month++;
    }

    return this.datesOf();
  }

  public datesOfPrevMonth(){
    if(this.month-1 < 0){
      this.year -= 1;
      this.month = 11;
    }  else {
      this.month--;
    }
    return this.datesOf();
  }

  private datesOf() {
    let dates = [];
    let daysInMonth = new Date(this.year, this.month+1, 0).getDate();
    let firstDayOfMonth = (new Date(this.year, this.month, 1).getDay() + 6) % 7; // Adjust to start from Monday

    for (let i = 0; i < firstDayOfMonth; i++) {
      dates.push(null);
    }

    for (let day = 1; day <= daysInMonth; day++) {
      dates.push(day);
    }
    return dates;
  }

  public toString(){
    return `${this.day}-${this.monthsName[this.month]}-${this.year}`
  }
}

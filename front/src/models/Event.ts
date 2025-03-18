export class Event {

  private name: string;
  private token: string;
  private participants: Participant[];

  public constructor(name: string, token : string, participants: Participant[]) {
    this.name = name;
    this.participants = participants;
  }

}

/*

{
    "name": "Event for test 2",
    "participants": [
        {
            "name": "tony",
            "dates": [
                {
                    "timestamp": 0
                },
                {
                    "timestamp": 2
                }
            ]
        }
    ]
}
 */

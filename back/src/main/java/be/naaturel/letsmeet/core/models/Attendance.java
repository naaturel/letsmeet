package be.naaturel.letsmeet.core.models;

public class Attendance {

    private EventDate date;
    private Attendee attendee;

    public Attendance(EventDate date, Attendee attendee) {
        this.date = date;
        this.attendee = attendee;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public EventDate getDate() {
        return date;
    }
}

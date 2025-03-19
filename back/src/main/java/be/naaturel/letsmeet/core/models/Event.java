package be.naaturel.letsmeet.core.models;

import java.util.*;

public class Event {

    private String name;
    private Set<Attendee> attendees;

    public Event(String name, Set<Attendee> attendees){
        this.name = name;
        this.attendees = attendees;
    }

    public String getName() {
        return name;
    }

    public Set<Attendee> getAttendees(){
        return new HashSet<>(this.attendees);
    }

    public Set<EventDate> getDates() {
        Set<EventDate> dates = new HashSet<>();
        for (Attendee p : this.attendees) {
            dates.addAll(p.getDates());
        }
        return dates;
    }
}

package be.naaturel.letsmeet.models;

import java.util.*;

public class Event {

    private String name;
    private Set<Participant> participants;

    public Event(String name, Set<Participant> participants){
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public Set<Participant> getParticipants(){
        return new HashSet<>(this.participants);
    }

    public Set<EventDate> getDates() {
        Set<EventDate> dates = new HashSet<>();
        for (Participant p : this.participants) {
            dates.addAll(p.getDates());
        }
        return dates;
    }
}

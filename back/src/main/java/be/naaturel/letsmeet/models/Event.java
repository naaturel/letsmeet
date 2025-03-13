package be.naaturel.letsmeet.models;

import java.util.*;

public class Event {

    private String name;
    private Map<Date, Set<Participant>> participants;

    public Event(String name){
        this(name, new HashMap<>());
    }

    public Event(String name, Set<Date> dates, Set<Participant> participants){
        this.name = name;
        this.participants = new HashMap<>();
    }

    public Event(String name, Map<Date, Set<Participant>> participants){
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return name;
    }

    public Set<Date> getDates() {
        return this.participants.keySet();
    }
}

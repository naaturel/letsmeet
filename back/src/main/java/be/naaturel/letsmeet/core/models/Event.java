package be.naaturel.letsmeet.core.models;

import java.util.Set;

public class Event {

    private String name;

    private Set<Attendance> attendances;

    public Event(String name, Set<Attendance> attendances) {
        this.name = name;
        this.attendances = attendances;
    }

    public String getName() {
        return name;
    }

    public Set<Attendance> getAttendances() {
        return this.attendances;
    }

}

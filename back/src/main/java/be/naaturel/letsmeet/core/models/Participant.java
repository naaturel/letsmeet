package be.naaturel.letsmeet.core.models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Participant {

    private String name;

    private Set<EventDate> dates;

    public Participant(String name){
        this(name, new HashSet<>());
    }

    public Participant(String name, Set<EventDate> dates){
        this.name = name;
        this.dates = dates;
    }


    public String getName() {
        return name;
    }

    public Set<EventDate> getDates() {
        return new HashSet<>(this.dates);
    }

    public void replaceDate(EventDate oldDate, EventDate newDate){
        dates.remove(oldDate);
        dates.add(newDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant date = (Participant) obj;
        return Objects.equals(name, date.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

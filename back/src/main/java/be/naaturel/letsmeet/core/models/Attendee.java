package be.naaturel.letsmeet.core.models;

import java.util.Objects;

public class Attendee {

    private String name;

    public Attendee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Attendee date = (Attendee) obj;
        return Objects.equals(name, date.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

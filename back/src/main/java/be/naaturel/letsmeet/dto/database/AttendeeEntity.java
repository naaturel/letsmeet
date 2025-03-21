package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Attendees")
public class AttendeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AttendeeEntity a = (AttendeeEntity) obj;
        return Objects.equals(name, a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}

package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Attendances")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_date_id", nullable = false)
    public EventDateEntity date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendee_id", nullable = false)
    public AttendeeEntity attendee;

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AttendanceEntity a = (AttendanceEntity) obj;
        return a.date.timeStamp == ((AttendanceEntity) obj).date.timeStamp &&
                a.attendee.name == ((AttendanceEntity) obj).attendee.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, attendee);
    }
}

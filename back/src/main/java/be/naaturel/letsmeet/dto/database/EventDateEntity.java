package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Dates")
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_id", "timestamp"})
})
public class EventDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public long timeStamp;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EventDateEntity date = (EventDateEntity) obj;
        return Objects.equals(timeStamp, date.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeStamp);
    }

}

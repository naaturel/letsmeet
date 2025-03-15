package be.naaturel.letsmeet.dto.database;

import be.naaturel.letsmeet.models.EventDate;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(nullable=true)
    public EventEntity event;

    @ManyToMany(mappedBy = "dates")
    public Set<ParticipantEntity> participants;

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

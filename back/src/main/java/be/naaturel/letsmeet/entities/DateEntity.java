package be.naaturel.letsmeet.entities;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity(name = "Date")
public class DateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @Column
    public long timeStamp;

    @ManyToOne
    @JoinColumn(name="eventId", nullable=false)
    public EventEntity event;

    @OneToMany(targetEntity= ParticipantEntity.class, cascade=ALL, mappedBy="id")
    public Set<ParticipantEntity> participants;
}

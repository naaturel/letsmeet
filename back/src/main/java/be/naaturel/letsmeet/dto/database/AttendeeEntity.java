package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Attendees")
public class AttendeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable
    public Set<EventDateEntity> dates;

    @ManyToOne
    @JoinColumn(nullable=true)
    public EventEntity event;

}

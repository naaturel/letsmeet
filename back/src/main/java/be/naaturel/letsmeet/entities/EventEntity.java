package be.naaturel.letsmeet.entities;

import jakarta.persistence.*;

import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity(name = "Event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    @OneToMany(targetEntity= DateEntity.class, cascade=ALL, mappedBy="event")
    public Set<DateEntity> timeStamps;

}

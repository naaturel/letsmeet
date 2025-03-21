package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @Column(unique = true)
    public String token;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_id")
    public Set<AttendanceEntity> attendances;

}


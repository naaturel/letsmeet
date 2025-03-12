package be.naaturel.letsmeet.entities;

import jakarta.persistence.*;

@Entity(name = "Participant")
public class ParticipantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @ManyToOne
    @JoinColumn(name="dateId", nullable=false)
    public DateEntity date;

}

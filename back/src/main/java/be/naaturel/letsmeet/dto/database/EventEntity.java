package be.naaturel.letsmeet.dto.database;

import be.naaturel.letsmeet.models.EventDate;
import be.naaturel.letsmeet.models.Participant;
import jakarta.persistence.*;

import java.util.*;

@Entity(name = "Events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @Column
    @OneToMany(targetEntity=EventDateEntity.class, cascade=CascadeType.ALL, mappedBy="event")
    public Set<EventDateEntity> dates;

    @Column
    @OneToMany(targetEntity=ParticipantEntity.class, cascade=CascadeType.ALL, mappedBy="event")
    public Set<ParticipantEntity> participants;

    public void linkDates(){
        for (EventDateEntity date : this.dates) {
            date.event = this;
        }
    }

    public void linkParticipants(){
        for (ParticipantEntity participant : this.participants) {
            participant.event = this;
        }
    }

    public void removeDuplicatedDates(){

        for (EventDateEntity ede: dates) {
            for (ParticipantEntity pe : participants) {
                if(pe.dates.contains(ede)){
                    pe.dates.remove(ede);
                    pe.dates.add(ede);
                }
            }
        }
    }
}


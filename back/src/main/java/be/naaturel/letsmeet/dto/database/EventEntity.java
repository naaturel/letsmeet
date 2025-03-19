package be.naaturel.letsmeet.dto.database;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "Events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public String id;

    @Column
    public String name;

    @Column(unique = true)
    public String token;

    @Column
    @OneToMany(targetEntity=EventDateEntity.class, cascade=CascadeType.ALL, mappedBy="event")
    public Set<EventDateEntity> dates;

    @Column
    @OneToMany(targetEntity=AttendeeEntity.class, cascade=CascadeType.ALL, mappedBy="event")
    public Set<AttendeeEntity> attendees;

    public void linkDates(){
        for (EventDateEntity date : this.dates) {
            date.event = this;
        }
    }

    public void linkAttendees(){
        for (AttendeeEntity attendee : this.attendees) {
            attendee.event = this;
        }
    }

    public void removeDuplicatedDates(){

        for (EventDateEntity ede: dates) {
            for (AttendeeEntity pe : attendees) {
                if(pe.dates.contains(ede)){
                    pe.dates.remove(ede);
                    pe.dates.add(ede);
                }
            }
        }
    }
}


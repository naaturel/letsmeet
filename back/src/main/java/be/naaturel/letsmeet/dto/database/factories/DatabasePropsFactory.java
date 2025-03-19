package be.naaturel.letsmeet.dto.database.factories;

import be.naaturel.letsmeet.core.helpers.TokenGenerator;
import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.database.AttendeeEntity;

import java.util.HashSet;
import java.util.Set;

public class DatabasePropsFactory {

    public static EventEntity createEvent(String name, Set<AttendeeEntity> attendees){

        EventEntity entity = new EventEntity();
        entity.name = name;
        entity.token = TokenGenerator.generate();
        entity.attendees = attendees;
        entity.dates = new HashSet<>();
        for (AttendeeEntity pe : entity.attendees) {
            entity.dates.addAll(pe.dates);
        }
        entity.linkDates();
        entity.linkAttendees();
        entity.removeDuplicatedDates();
        return entity;
    }

    public static AttendeeEntity createAttendee(String name, Set<EventDateEntity> dates){
        AttendeeEntity entity = new AttendeeEntity();
        entity.name = name;
        entity.dates = dates;
        return entity;
    }

    public static EventDateEntity createDate(long timestamp){
        EventDateEntity entity = new EventDateEntity();
        entity.timeStamp = timestamp;
        return entity;
    }

}

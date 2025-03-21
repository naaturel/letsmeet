package be.naaturel.letsmeet.repositories;

import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.dto.database.AttendanceEntity;
import be.naaturel.letsmeet.dto.database.AttendeeEntity;
import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.mappers.database.EventMapper;
import be.naaturel.letsmeet.repositories.interfaces.AttendanceEntityRepo;
import be.naaturel.letsmeet.repositories.interfaces.AttendeeEntityRepo;
import be.naaturel.letsmeet.repositories.interfaces.EventDateEntityRepo;
import be.naaturel.letsmeet.repositories.interfaces.EventEntityRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventRepo {

    private final EventEntityRepo eventRepo;
    private final AttendeeEntityRepo attendeeRepo;
    private final EventDateEntityRepo dateRepo;
    private final AttendanceEntityRepo attendanceRepo;
    private final Mapper<Event, EventEntity> mapper;

    @Autowired
    public EventRepo(EventEntityRepo eventRepo, AttendeeEntityRepo attendeeRepo,
                     EventDateEntityRepo dateRepo, AttendanceEntityRepo attendanceRepo) {
        this.eventRepo = eventRepo;
        this.attendeeRepo = attendeeRepo;
        this.dateRepo = dateRepo;
        this.attendanceRepo = attendanceRepo;
        this.mapper = new EventMapper();
    }

    @Transactional
    public String save(Event e) {
        //Hacky way to avoid duplication through relationship insertion.
        //I didn't want to do that, but after going through the five stages
        // of grief and spending many hours (like way too much) looking for a cleaner
        // solution, it seems JPA has no built-in way to achieve it

        EventEntity event = getAsEntity(e);
        Map<AttendeeEntity, AttendeeEntity> insertedAttendees = new HashMap<>();
        Map<EventDateEntity, EventDateEntity> insertedDates = new HashMap<>();

        for (AttendanceEntity attendance : event.attendances) {
            AttendeeEntity attendee = attendance.attendee;
            EventDateEntity date = attendance.date;

            if (!insertedAttendees.containsKey(attendee)) {
                insertedAttendees.put(attendee, attendee);
                attendeeRepo.save(attendee);
            } else {
                attendance.attendee = insertedAttendees.get(attendee);
            }

            if (!insertedDates.containsKey(date)) {
                insertedDates.put(date, date);
                dateRepo.save(date);
            } else {
                attendance.date = insertedDates.get(date);
            }
        }
        EventEntity result = eventRepo.save(event);
        return result.token;
    }


    public Event getByToken(String token) {
        EventEntity entity = this.eventRepo.findEventEntityByToken(token);
        return mapper.toModel(entity);
    }

    public void delete(Event event) {

    }

    private EventEntity getAsEntity(Event e) {
        return mapper.toEntity(e);
    }


}

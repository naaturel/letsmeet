package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.core.helpers.TokenGenerator;
import be.naaturel.letsmeet.core.models.Attendance;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.dto.database.AttendanceEntity;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.mappers.Mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class EventMapper implements Mapper<Event, EventEntity> {

    private final Mapper<Attendance, AttendanceEntity> attendanceMapper;

    public EventMapper() {
        this.attendanceMapper = new AttendanceMapper();
    }

    @Override
    public EventEntity toEntity(Event event) {
        EventEntity entity = new EventEntity();
        entity.name = event.getName();
        entity.token = TokenGenerator.generate();
        entity.attendances = attendanceMapper.toEntities(event.getAttendances(), HashSet::new);
        return entity;
    }

    @Override
    public Event toModel(EventEntity eventEntity) {
        Set<Attendance> attendances = attendanceMapper.toModels(eventEntity.attendances, HashSet::new);
        return new Event(eventEntity.name, attendances);
    }


    @Override
    public <C extends Collection<EventEntity>> C toEntities(Collection<Event> events, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        events.forEach(e -> result.add(toEntity(e)));
        return result;
    }

    @Override
    public <C extends Collection<Event>> C toModels(Collection<EventEntity> eventEntities, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        eventEntities.forEach(e -> result.add(toModel(e)));
        return result;
    }

}

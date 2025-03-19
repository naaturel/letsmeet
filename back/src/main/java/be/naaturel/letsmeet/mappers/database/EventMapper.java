package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.database.AttendeeEntity;
import be.naaturel.letsmeet.dto.database.factories.DatabasePropsFactory;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.core.models.Attendee;

import java.util.*;
import java.util.function.Supplier;

public class EventMapper implements Mapper<Event, EventEntity> {

    private final Mapper<Attendee, AttendeeEntity> attendeeMapper;

    public EventMapper(){
        this.attendeeMapper = new AttendeeMapper();
    }

    @Override
    public EventEntity toEntity(Event event) {
        return DatabasePropsFactory.createEvent(event.getName(), attendeeMapper.toEntities(event.getAttendees(), HashSet::new));
    }

    @Override
    public Event toModel(EventEntity eventEntity) {
        return new Event(eventEntity.name, attendeeMapper.toModels(eventEntity.attendees, HashSet::new));
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

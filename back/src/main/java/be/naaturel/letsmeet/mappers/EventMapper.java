package be.naaturel.letsmeet.mappers;

import be.naaturel.letsmeet.entities.DateEntity;
import be.naaturel.letsmeet.entities.EventEntity;
import be.naaturel.letsmeet.models.Date;
import be.naaturel.letsmeet.models.Event;

import java.util.*;
import java.util.function.Supplier;

public class EventMapper implements Mapper<Event, EventEntity> {

    private final Mapper<Date, DateEntity> dateMapper;

    public EventMapper(){
        this.dateMapper = new DateMapper();
    }

    @Override
    public EventEntity toEntity(Event event) {
        EventEntity ee = new EventEntity();
        ee.name = event.getName();
        ee.timeStamps = dateMapper.toEntities(event.getDates(), HashSet::new);
        return ee;
    }

    @Override
    public Event toModel(EventEntity eventEntity) {
        return new Event(eventEntity.name);
    }

    @Override
    public <C extends Collection<EventEntity>> C toEntities(Collection<Event> events, Supplier<C> collectionSupplier) {
        return null;
    }

    @Override
    public <C extends Collection<Event>> C toModels(Collection<EventEntity> eventEntities, Supplier<C> collectionSupplier) {
        return null;
    }

}

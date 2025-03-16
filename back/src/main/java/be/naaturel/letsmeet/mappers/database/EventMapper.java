package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.database.ParticipantEntity;
import be.naaturel.letsmeet.dto.database.factories.DatabasePropsFactory;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.core.models.Participant;

import java.util.*;
import java.util.function.Supplier;

public class EventMapper implements Mapper<Event, EventEntity> {

    private final Mapper<Participant, ParticipantEntity> participantMapper;

    public EventMapper(){
        this.participantMapper = new ParticipantMapper();
    }

    @Override
    public EventEntity toEntity(Event event) {
        return DatabasePropsFactory.createEvent(event.getName(), participantMapper.toEntities(event.getParticipants(), HashSet::new));
    }

    @Override
    public Event toModel(EventEntity eventEntity) {
        return new Event(eventEntity.name, participantMapper.toModels(eventEntity.participants, HashSet::new));
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

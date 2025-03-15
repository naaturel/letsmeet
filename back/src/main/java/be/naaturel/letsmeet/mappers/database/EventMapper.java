package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.database.ParticipantEntity;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.models.Event;
import be.naaturel.letsmeet.models.Participant;

import java.util.*;
import java.util.function.Supplier;

public class EventMapper implements Mapper<Event, EventEntity> {

    private final Mapper<Participant, ParticipantEntity> participantMapper;

    public EventMapper(){
        this.participantMapper = new ParticipantMapper();
    }

    @Override
    public EventEntity toEntity(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.name = event.getName();
        eventEntity.participants = participantMapper.toEntities(event.getParticipants(), HashSet::new);

        eventEntity.dates = new HashSet<>();
        for (ParticipantEntity pe : eventEntity.participants) {
            eventEntity.dates.addAll(pe.dates);
        }
        return eventEntity;
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

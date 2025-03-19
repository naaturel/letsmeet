package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.dto.httpRequest.AttendeeDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.core.models.Attendee;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class EventDTOMapper implements Mapper<Event, EventDTO> {

    private final Mapper<Attendee, AttendeeDTO> attendeeMapper = new AttendeeDTOMapper();

    @Override
    public EventDTO toEntity(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.name = event.getName();
        eventDTO.attendees = attendeeMapper.toEntities(event.getAttendees(), HashSet::new);
        return eventDTO;
    }

    @Override
    public Event toModel(EventDTO dto) {
        return new Event(dto.name, attendeeMapper.toModels(dto.attendees, HashSet::new));
    }

    @Override
    public <C extends Collection<EventDTO>> C toEntities(Collection<Event> events, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        events.forEach(e -> result.add(toEntity(e)));
        return result;
    }

    @Override
    public <C extends Collection<Event>> C toModels(Collection<EventDTO> eventDTOS, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        eventDTOS.forEach(e -> result.add(toModel(e)));
        return result;
    }
}

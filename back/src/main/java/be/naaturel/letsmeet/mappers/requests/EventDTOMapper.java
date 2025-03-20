package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.dto.httpRequest.AttendeeDTO;
import be.naaturel.letsmeet.dto.httpRequest.EventDateDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.core.models.Attendee;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class EventDTOMapper implements Mapper<Event, EventDTO> {

    private final Mapper<Attendee, AttendeeDTO> attendeeMapper = new AttendeeDTOMapper();
    private final Mapper<EventDate, EventDateDTO> dateMapper = new EventDateDTOMapper();

    @Override
    public EventDTO toEntity(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.name = event.getName();
        //eventDTO.dates = attendeeMapper.toEntities(event.getAttendees(), HashSet::new);

        //TODO : MUST BE CLEANED
        eventDTO.dates = new HashMap<>();
        event.getAttendees().forEach(a -> {
            a.getDates().forEach(d -> {
                EventDateDTO dtoD = dateMapper.toEntity(d);
                AttendeeDTO dtoA = attendeeMapper.toEntity(a);
                String key = String.valueOf(d.getTimeStamp());
                if(eventDTO.dates.containsKey(key)){
                    eventDTO.dates.get(key).add(dtoA);
                } else {
                    Set<AttendeeDTO> s = new HashSet<>();
                    s.add(dtoA);
                    eventDTO.dates.put(key, s);
                }
            });
        });

        return eventDTO;
    }

    @Override
    public Event toModel(EventDTO dto) {
        //return new Event(dto.name, attendeeMapper.toModels(dto.dates, HashSet::new));
        Set<Attendee> set = new HashSet<>();
        for (String key : dto.dates.keySet()) {
            set.addAll(attendeeMapper.toModels(dto.dates.get(key), HashSet::new));
        }
        return new Event(dto.name, set);
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

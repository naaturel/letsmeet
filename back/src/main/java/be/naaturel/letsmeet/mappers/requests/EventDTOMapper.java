package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.core.models.Attendance;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.dto.httpRequest.AttendanceDTO;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.mappers.Mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class EventDTOMapper implements Mapper<Event, EventDTO> {

    private final Mapper<Attendance, AttendanceDTO> attendanceMapper;

    public EventDTOMapper() {
        this.attendanceMapper = new AttendanceDTOMapper();
    }

    @Override
    public EventDTO toEntity(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.name = event.getName();
        eventDTO.attendances = attendanceMapper.toEntities(event.getAttendances(), HashSet::new);
        return eventDTO;
    }

    @Override
    public Event toModel(EventDTO dto) {
        Set<Attendance> attendances = attendanceMapper.toModels(dto.attendances, HashSet::new);
        return new Event(dto.name, attendances);
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

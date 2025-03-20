package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.dto.httpRequest.EventDateDTO;
import be.naaturel.letsmeet.dto.httpRequest.AttendeeDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.core.models.Attendee;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class AttendeeDTOMapper implements Mapper<Attendee, AttendeeDTO> {

    private final Mapper<EventDate, EventDateDTO> dateMapper;

    public AttendeeDTOMapper(){
        this.dateMapper = new EventDateDTOMapper();
    }

    @Override
    public AttendeeDTO toEntity(Attendee d) {
        AttendeeDTO dto = new AttendeeDTO();
        dto.name = d.getName();
        return dto;
    }

    @Override
    public Attendee toModel(AttendeeDTO d) {
        return null;
    }

    @Override
    public <C extends Collection<AttendeeDTO>> C toEntities(Collection<Attendee> attendees, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendees.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Attendee>> C toModels(Collection<AttendeeDTO> attendeeDTOS, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendeeDTOS.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

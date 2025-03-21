package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.core.models.Attendance;
import be.naaturel.letsmeet.core.models.Attendee;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.dto.httpRequest.AttendanceDTO;
import be.naaturel.letsmeet.dto.httpRequest.AttendeeDTO;
import be.naaturel.letsmeet.dto.httpRequest.EventDateDTO;
import be.naaturel.letsmeet.mappers.Mapper;

import java.util.Collection;
import java.util.function.Supplier;

public class AttendanceDTOMapper implements Mapper<Attendance, AttendanceDTO> {

    private final Mapper<Attendee, AttendeeDTO> attendeeMapper;
    private final Mapper<EventDate, EventDateDTO> dateMapper;

    public AttendanceDTOMapper() {
        this.attendeeMapper = new AttendeeDTOMapper();
        this.dateMapper = new EventDateDTOMapper();
    }

    @Override
    public AttendanceDTO toEntity(Attendance d) {
        AttendanceDTO dto = new AttendanceDTO();
        dto.attendee = attendeeMapper.toEntity(d.getAttendee());
        dto.date = dateMapper.toEntity(d.getDate());
        return dto;
    }

    @Override
    public Attendance toModel(AttendanceDTO d) {
        Attendee attendee = attendeeMapper.toModel(d.attendee);
        EventDate date = dateMapper.toModel(d.date);
        return new Attendance(date, attendee);
    }

    @Override
    public <C extends Collection<AttendanceDTO>> C toEntities(Collection<Attendance> attendances, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendances.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Attendance>> C toModels(Collection<AttendanceDTO> attendances, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendances.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

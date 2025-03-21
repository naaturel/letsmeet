package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.core.models.Attendance;
import be.naaturel.letsmeet.core.models.Attendee;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.dto.database.AttendanceEntity;
import be.naaturel.letsmeet.dto.database.AttendeeEntity;
import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.mappers.Mapper;

import java.util.Collection;
import java.util.function.Supplier;

public class AttendanceMapper implements Mapper<Attendance, AttendanceEntity> {
    private final Mapper<Attendee, AttendeeEntity> attendeeMapper;
    private final Mapper<EventDate, EventDateEntity> dateMapper;

    public AttendanceMapper() {
        this.attendeeMapper = new AttendeeMapper();
        this.dateMapper = new EventDateMapper();
    }

    @Override
    public AttendanceEntity toEntity(Attendance d) {
        AttendanceEntity dto = new AttendanceEntity();
        dto.attendee = attendeeMapper.toEntity(d.getAttendee());
        dto.date = dateMapper.toEntity(d.getDate());
        return dto;
    }

    @Override
    public Attendance toModel(AttendanceEntity d) {
        Attendee attendee = attendeeMapper.toModel(d.attendee);
        EventDate date = dateMapper.toModel(d.date);
        return new Attendance(date, attendee);
    }

    @Override
    public <C extends Collection<AttendanceEntity>> C toEntities(Collection<Attendance> attendances, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendances.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Attendance>> C toModels(Collection<AttendanceEntity> attendances, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendances.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

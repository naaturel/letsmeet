package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.AttendeeEntity;
import be.naaturel.letsmeet.dto.database.factories.DatabasePropsFactory;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.core.models.Attendee;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class AttendeeMapper implements Mapper<Attendee, AttendeeEntity> {


    private final Mapper<EventDate, EventDateEntity> dateMapper;

    public AttendeeMapper(){
        dateMapper = new EventDateMapper();
    }

    @Override
    public AttendeeEntity toEntity(Attendee d) {
        return DatabasePropsFactory.createAttendee(d.getName(), dateMapper.toEntities(d.getDates(), HashSet::new));
    }

    @Override
    public Attendee toModel(AttendeeEntity d) {
        return new Attendee(d.name, dateMapper.toModels(d.dates, HashSet::new));
    }

    @Override
    public <C extends Collection<AttendeeEntity>> C toEntities(Collection<Attendee> attendees, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendees.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Attendee>> C toModels(Collection<AttendeeEntity> attendees, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        attendees.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.factories.DatabasePropsFactory;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.models.EventDate;

import java.util.Collection;
import java.util.function.Supplier;


public class EventDateMapper implements Mapper<EventDate, EventDateEntity> {

    @Override
    public EventDateEntity toEntity(EventDate d) {
        return DatabasePropsFactory.createDate(d.getTimeStamp());
    }

    @Override
    public EventDate toModel(EventDateEntity d) {
        return new EventDate(d.timeStamp);
    }

    @Override
    public <C extends Collection<EventDateEntity>> C toEntities(Collection<EventDate> dates, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        dates.forEach(d -> result.add(toEntity(d)));
        return result;
    }

    @Override
    public <C extends Collection<EventDate>> C toModels(Collection<EventDateEntity> e, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        e.forEach(r -> result.add(toModel(r)));
        return result;
    }
}

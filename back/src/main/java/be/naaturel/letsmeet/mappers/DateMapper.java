package be.naaturel.letsmeet.mappers;

import be.naaturel.letsmeet.entities.DateEntity;
import be.naaturel.letsmeet.models.Date;

import java.util.Collection;
import java.util.function.Supplier;


public class DateMapper implements Mapper<Date, DateEntity> {
    @Override
    public DateEntity toEntity(Date d) {
        DateEntity de = new DateEntity();
        de.timeStamp = d.timeStamp;
        return de;
    }

    @Override
    public Date toModel(DateEntity d) {
        return new Date(d.timeStamp);
    }

    @Override
    public <C extends Collection<DateEntity>> C toEntities(Collection<Date> e, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        e.forEach(r -> result.add(toEntity(r)));
        return result;
    }

    @Override
    public <C extends Collection<Date>> C toModels(Collection<DateEntity> e, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        e.forEach(r -> result.add(toModel(r)));
        return result;
    }
}

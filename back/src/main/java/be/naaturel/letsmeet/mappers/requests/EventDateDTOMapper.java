package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.dto.httpRequest.EventDateDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.EventDate;

import java.util.Collection;
import java.util.function.Supplier;

public class EventDateDTOMapper implements Mapper<EventDate, EventDateDTO> {

    @Override
    public EventDateDTO toEntity(EventDate d) {
        EventDateDTO dto = new EventDateDTO();
        dto.timestamp = d.getTimeStamp();
        return dto;
    }

    @Override
    public EventDate toModel(EventDateDTO d) {
        return new EventDate(d.timestamp);
    }

    @Override
    public <C extends Collection<EventDateDTO>> C toEntities(Collection<EventDate> dates, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        dates.forEach(d -> result.add(toEntity(d)));
        return result;
    }

    @Override
    public <C extends Collection<EventDate>> C toModels(Collection<EventDateDTO> dates, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        dates.forEach(d -> result.add(toModel(d)));
        return result;
    }
}

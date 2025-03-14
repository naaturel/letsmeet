package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.ParticipantEntity;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.models.EventDate;
import be.naaturel.letsmeet.models.Participant;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class ParticipantMapper implements Mapper<Participant, ParticipantEntity> {


    private final Mapper<EventDate, EventDateEntity> dateMapper;

    public ParticipantMapper(){
        dateMapper = new EventDateMapper();
    }

    @Override
    public ParticipantEntity toEntity(Participant d) {
        ParticipantEntity pe = new ParticipantEntity();
        pe.name = d.getName();
        pe.dates = dateMapper.toEntities(d.getDates(), HashSet::new);
        return pe;
    }

    @Override
    public Participant toModel(ParticipantEntity d) {
        return new Participant(d.name);
    }

    @Override
    public <C extends Collection<ParticipantEntity>> C toEntities(Collection<Participant> participants, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        participants.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Participant>> C toModels(Collection<ParticipantEntity> participants, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        participants.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

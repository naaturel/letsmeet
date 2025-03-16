package be.naaturel.letsmeet.mappers.database;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.ParticipantEntity;
import be.naaturel.letsmeet.dto.database.factories.DatabasePropsFactory;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.core.models.Participant;

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
        return DatabasePropsFactory.createParticipant(d.getName(), dateMapper.toEntities(d.getDates(), HashSet::new));
    }

    @Override
    public Participant toModel(ParticipantEntity d) {
        return new Participant(d.name, dateMapper.toModels(d.dates, HashSet::new));
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

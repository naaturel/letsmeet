package be.naaturel.letsmeet.mappers.requests;

import be.naaturel.letsmeet.dto.httpRequest.EventDateDTO;
import be.naaturel.letsmeet.dto.httpRequest.ParticipantDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.core.models.EventDate;
import be.naaturel.letsmeet.core.models.Participant;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class ParticipantDTOMapper implements Mapper<Participant, ParticipantDTO> {

    private final Mapper<EventDate, EventDateDTO> dateMapper;

    public ParticipantDTOMapper(){
        this.dateMapper = new EventDateDTOMapper();
    }

    @Override
    public ParticipantDTO toEntity(Participant d) {
        ParticipantDTO dto = new ParticipantDTO();
        dto.name = d.getName();
        dto.dates = dateMapper.toEntities(d.getDates(), HashSet::new);
        return dto;
    }

    @Override
    public Participant toModel(ParticipantDTO d) {
        return new Participant(d.name, dateMapper.toModels(d.dates, HashSet::new));
    }

    @Override
    public <C extends Collection<ParticipantDTO>> C toEntities(Collection<Participant> participants, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        participants.forEach(p -> result.add(toEntity(p)));
        return result;
    }

    @Override
    public <C extends Collection<Participant>> C toModels(Collection<ParticipantDTO> participantDTOS, Supplier<C> collectionSupplier) {
        C result = collectionSupplier.get();
        participantDTOS.forEach(p -> result.add(toModel(p)));
        return result;
    }
}

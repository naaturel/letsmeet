package be.naaturel.letsmeet.mappers.dto;

import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.mappers.requests.EventDTOMapper;
import be.naaturel.letsmeet.mock.dto.MockEventDTO;
import be.naaturel.letsmeet.mock.models.MockEventModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventDTOMapperTest {

    private static MockEventDTO mockDto;
    private static MockEventModel mockModel;
    private static Mapper<Event, EventDTO> mapper;

    @BeforeAll
    static void setup(){
        mockDto = new MockEventDTO();
        mockModel = new MockEventModel();
        mapper = new EventDTOMapper();
    }

    @Test
    void single_dto_to_model_test(){
        Event res = mapper.toModel(mockDto);
        assertEquals(res.getName(), mockDto.name);
    }

    @Test
    void single_model_to_dto_test(){
        EventDTO res = mapper.toEntity(mockModel);
        assertEquals(res.name, mockModel.getName());
    }

    @Test
    void multiple_dto_to_models_test(){
        List<Event> res = mapper.toModels(Set.of(mockDto), ArrayList::new);
        assertEquals(res.size(), 1);
        assertEquals(res.getFirst().getName(), mockDto.name);
    }

    @Test
    void mulitple_models_to_dto_test(){
        List<EventDTO> res = mapper.toEntities(Set.of(mockModel), ArrayList::new);
        assertEquals(res.size(), 1);
        assertEquals(res.getFirst().name, mockModel.getName());
    }
}

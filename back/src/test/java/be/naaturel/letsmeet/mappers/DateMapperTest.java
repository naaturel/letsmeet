package be.naaturel.letsmeet.mappers;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.mappers.Mapper;
import be.naaturel.letsmeet.mappers.database.EventDateMapper;
import be.naaturel.letsmeet.core.models.EventDate;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateMapperTest {

    private static final Mapper<EventDate, EventDateEntity> mapper = new EventDateMapper();
    private static final EventDate model = new EventDate(0);
    private static final Set<EventDate> models = Set.of(new EventDate(0), new EventDate(1), new EventDate(2));
    private static final EventDateEntity entity = new EventDateEntity();
    private static final Set<EventDateEntity> entities = new HashSet<>();

    @BeforeAll
    static void setup(){
        entity.timeStamp = 0;

        entities.add(new EventDateEntity());
        entities.add(new EventDateEntity());
        entities.add(new EventDateEntity());
    }

    @Test
    void single_model_to_entity() {
        EventDateEntity converted = mapper.toEntity(model);
        assertEquals(converted.timeStamp, model.getTimeStamp());
    }

    @Test
    void single_entity_to_model() {
        EventDate converted = mapper.toModel(entity);
        assertEquals(converted.getTimeStamp(), entity.timeStamp);
    }

    @Test
    void multiple_entities_to_models() {
        Set<EventDate> dates = mapper.toModels(entities, HashSet::new);
        assertEquals(dates.size(), entities.size());
    }

    @Test
    void multiple_models_to_entities() {
        Set<EventDateEntity> dates = mapper.toEntities(models, HashSet::new);
        assertEquals(dates.size(), models.size());
    }

}

package be.naaturel.letsmeet.mappers;

import be.naaturel.letsmeet.entities.DateEntity;
import be.naaturel.letsmeet.models.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateMapperTest {

    private static final Mapper<Date, DateEntity> mapper = new DateMapper();
    private static final Date model = new Date(0);
    private static final Set<Date> models = Set.of(new Date(0), new Date(1), new Date(2));
    private static final DateEntity entity = new DateEntity();
    private static final Set<DateEntity> entities = new HashSet<>();

    @BeforeAll
    static void setup(){
        entity.id = "BLA BLA BLA FAKE ID";
        entity.timeStamp = 0;

        entities.add(new DateEntity());
        entities.add(new DateEntity());
        entities.add(new DateEntity());
    }

    @Test
    void single_model_to_entity() {
        DateEntity converted = mapper.toEntity(model);
        assertEquals(converted.timeStamp, model.timeStamp);
    }

    @Test
    void single_entity_to_model() {
        Date converted = mapper.toModel(entity);
        assertEquals(converted.timeStamp, model.timeStamp);
    }

    @Test
    void multiple_entities_to_models() {
        Set<Date> dates = mapper.toModels(entities, HashSet::new);
        assertEquals(dates.size(), entities.size());
    }

    @Test
    void multiple_models_to_entities() {
        Set<DateEntity> dates = mapper.toEntities(models, HashSet::new);
        assertEquals(dates.size(), models.size());
    }

}

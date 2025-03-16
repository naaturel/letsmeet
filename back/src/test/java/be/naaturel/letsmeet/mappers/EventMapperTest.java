package be.naaturel.letsmeet.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventMapperTest {
    /*private static final Mapper<Event, EventEntity> mapper = new EventMapper();

    private static final Set<EventDate> dates = Set.of(new EventDate(0, new HashSet<>()));

    private static final Event model = new Event("Event for tests", dates);

    private static final List<Event> models = List.of(model, model, model);

    private static final EventEntity entity = new EventEntity();
    private static final List<EventEntity> entities = new ArrayList<>();

    @BeforeAll
    static void setup(){
        entity.id = "BLA BLA BLA FAKE ID";
        entity.name = "Event entity for tests";
        entity.dates = Set.of(new EventDateEntity(), new EventDateEntity(), new EventDateEntity());

        entities.add(entity);
        entities.add(entity);
        entities.add(entity);
    }


    @Test
    void single_model_to_entity() {
        EventEntity converted = mapper.toEntity(model);
        assertEquals(converted.name, model.getName());
        assertEquals(converted.dates.size(), model.getDates().size());
    }

    @Test
    void single_entity_to_model() {
        Event converted = mapper.toModel(entity);
        assertEquals(converted.getName(), entity.name);
        //assertEquals(converted.getDates().size(), entity.dates.size());
    }

    @Test
    void multiple_entities_to_models() {
        List<Event> events = mapper.toModels(entities, ArrayList::new);
        assertEquals(events.size(), entities.size());
    }

    @Test
    void multiple_models_to_entities() {
        List<EventEntity> eventEntities = mapper.toEntities(models, ArrayList::new);
        assertEquals(eventEntities.size(), models.size());
    }*/

}

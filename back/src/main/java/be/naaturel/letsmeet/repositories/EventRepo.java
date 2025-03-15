package be.naaturel.letsmeet.repositories;

import be.naaturel.letsmeet.dto.database.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepo
        extends JpaRepository<EventEntity, String> {

    @Query(value = "SELECT * FROM events;", nativeQuery = true)
    List<EventEntity> findEventEntityById(String id);
}

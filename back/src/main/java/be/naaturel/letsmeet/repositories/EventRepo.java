package be.naaturel.letsmeet.repositories;

import be.naaturel.letsmeet.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EventRepo
        extends JpaRepository<EventEntity, String> {

    @Query(value = "SELECT * FROM events WHERE ;", nativeQuery = true)
    List<EventEntity> findEventEntityById(String id);
}

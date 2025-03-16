package be.naaturel.letsmeet.repositories;

import be.naaturel.letsmeet.dto.database.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepo
        extends JpaRepository<EventEntity, String> {

    @Query(value = "SELECT * FROM events e WHERE e.token = :#{#token};", nativeQuery = true)
    EventEntity findEventEntityByToken(@Param("token") String token);
}

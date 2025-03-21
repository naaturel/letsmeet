package be.naaturel.letsmeet.repositories.interfaces;

import be.naaturel.letsmeet.dto.database.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventEntityRepo extends JpaRepository<EventEntity, String> {

    @Query(value = "SELECT * FROM events e WHERE e.token = :#{#token};", nativeQuery = true)
    EventEntity findEventEntityByToken(@Param("token") String token);

}

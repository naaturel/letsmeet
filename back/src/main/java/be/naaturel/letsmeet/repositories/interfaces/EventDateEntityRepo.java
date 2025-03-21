package be.naaturel.letsmeet.repositories.interfaces;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDateEntityRepo extends JpaRepository<EventDateEntity, String> {

    //@Query(value = "SELECT * FROM events e WHERE e.token = :#{#token};", nativeQuery = true)
    //EventEntity findEventEntityByToken(@Param("token") String token);

}

package be.naaturel.letsmeet.repositories;

import be.naaturel.letsmeet.entities.EventEntity;
import be.naaturel.letsmeet.models.Event;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class Seeder {

    @Bean
    public CommandLineRunner seedDatabase(EventRepo eventRepo) {
        return args -> {
            if (eventRepo.count() == 0) {
                eventRepo.save(new EventEntity());
                eventRepo.save(new EventEntity());
            }
        };
    }
}
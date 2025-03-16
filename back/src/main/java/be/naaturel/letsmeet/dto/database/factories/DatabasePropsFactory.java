package be.naaturel.letsmeet.dto.database.factories;

import be.naaturel.letsmeet.core.helpers.TokenGenerator;
import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.database.ParticipantEntity;

import java.util.HashSet;
import java.util.Set;

public class DatabasePropsFactory {

    public static EventEntity createEvent(String name, Set<ParticipantEntity> participants){

        EventEntity entity = new EventEntity();
        entity.name = name;
        entity.token = TokenGenerator.generate();
        entity.participants = participants;
        entity.dates = new HashSet<>();
        for (ParticipantEntity pe : entity.participants) {
            entity.dates.addAll(pe.dates);
        }
        entity.linkDates();
        entity.linkParticipants();
        entity.removeDuplicatedDates();
        return entity;
    }

    public static ParticipantEntity createParticipant(String name, Set<EventDateEntity> dates){
        ParticipantEntity entity = new ParticipantEntity();
        entity.name = name;
        entity.dates = dates;
        return entity;
    }

    public static EventDateEntity createDate(long timestamp){
        EventDateEntity entity = new EventDateEntity();
        entity.timeStamp = timestamp;
        return entity;
    }

}

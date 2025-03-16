package be.naaturel.letsmeet.services;

import be.naaturel.letsmeet.dto.database.EventDateEntity;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.mappers.database.EventMapper;
import be.naaturel.letsmeet.mappers.requests.EventDTOMapper;
import be.naaturel.letsmeet.models.Event;
import be.naaturel.letsmeet.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractService<Event, EventEntity, EventDTO> {

    @Autowired
    public EventService(EventRepo eventRepo){
        super(eventRepo, new EventMapper(), new EventDTOMapper());
    }

    @Override
    public boolean save(EventDTO dto) {
        Event event = this.requestMapper.toModel(dto);
        EventEntity entity = this.dataBaseMapper.toEntity(event);
        try{
            this.repo.save(entity);
            return true;
        } catch (IllegalArgumentException iae){
            return false;
        } catch (OptimisticLockingFailureException olfe){
            return false;
        }
    }

    @Override
    public boolean delete(EventDTO dto) {
        Event event = this.requestMapper.toModel(dto);
        EventEntity entity = this.dataBaseMapper.toEntity(event);
        try{
            this.repo.delete(entity);
            return true;
        } catch (IllegalArgumentException iae){
            return false;
        } catch (OptimisticLockingFailureException olfe){
            return false;
        }
    }

}

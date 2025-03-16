package be.naaturel.letsmeet.services;

import be.naaturel.letsmeet.core.Result;
import be.naaturel.letsmeet.dto.database.EventEntity;
import be.naaturel.letsmeet.dto.httpRequest.EventDTO;
import be.naaturel.letsmeet.mappers.database.EventMapper;
import be.naaturel.letsmeet.mappers.requests.EventDTOMapper;
import be.naaturel.letsmeet.core.models.Event;
import be.naaturel.letsmeet.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class EventService extends AbstractService<Event, EventEntity, EventDTO> {

    protected EventRepo repo;

    @Autowired
    public EventService(EventRepo eventRepo){
        super(new EventMapper(), new EventDTOMapper());
        this.repo = eventRepo;
    }

    @Override
    public Result<String> save(EventDTO dto) throws Exception {
        Event event = this.requestMapper.toModel(dto);
        EventEntity entity = this.dataBaseMapper.toEntity(event);
        try{
            this.repo.save(entity);
            return new Result<>(entity.token);
        } catch (Exception e) {
            throw new Exception("Something went wrong");
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

    public EventDTO getEvent(String token){
        try{
            EventEntity entity = this.repo.findEventEntityByToken(token);
            Event model = dataBaseMapper.toModel(entity);
            EventDTO dto = requestMapper.toEntity(model);
            return dto;
        } catch (Exception e){
            return null;
        }
    }
}

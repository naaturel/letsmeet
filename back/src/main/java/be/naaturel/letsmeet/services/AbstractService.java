package be.naaturel.letsmeet.services;


import be.naaturel.letsmeet.mappers.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T, T_ENTITY, T_DTO> {

    protected JpaRepository<T_ENTITY, String> repo;
    protected Mapper<T, T_ENTITY> dataBaseMapper;
    protected Mapper<T, T_DTO> requestMapper;

    AbstractService(JpaRepository<T_ENTITY, String> repo, Mapper<T, T_ENTITY> dataBaseMapper, Mapper<T, T_DTO> requestMapper){
        this.repo = repo;
        this.dataBaseMapper = dataBaseMapper;
        this.requestMapper = requestMapper;
    }

    public abstract boolean save(T_DTO prop);
    public abstract boolean delete(T_DTO prop);


}

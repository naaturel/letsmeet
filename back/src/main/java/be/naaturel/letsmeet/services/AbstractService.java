package be.naaturel.letsmeet.services;

import be.naaturel.letsmeet.mappers.Mapper;

public abstract class AbstractService<T, T_ENTITY, T_DTO> {

    protected Mapper<T, T_ENTITY> dataBaseMapper;
    protected Mapper<T, T_DTO> requestMapper;

    AbstractService(Mapper<T, T_ENTITY> dataBaseMapper, Mapper<T, T_DTO> requestMapper){
        this.dataBaseMapper = dataBaseMapper;
        this.requestMapper = requestMapper;
    }

    public abstract boolean save(T_DTO prop);
    public abstract boolean delete(T_DTO prop);


}

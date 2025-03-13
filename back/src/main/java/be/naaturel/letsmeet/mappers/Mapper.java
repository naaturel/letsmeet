package be.naaturel.letsmeet.mappers;

import java.util.Collection;
import java.util.function.Supplier;

public interface Mapper<T, T_ENTITY>  {

    T_ENTITY toEntity(T d);

    T toModel(T_ENTITY d);

    <C extends Collection<T_ENTITY>> C toEntities(Collection<T> e, Supplier<C> collectionSupplier);

    <C extends Collection<T>> C toModels(Collection<T_ENTITY> e, Supplier<C> collectionSupplier);
}


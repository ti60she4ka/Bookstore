package eu.senla.api.repositories;

import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.BaseEntity;

import java.util.List;

public interface AbstractRepository<T extends BaseEntity> {
    void create(T entity);

    void update(T entity);

    void delete(int id) throws EntityNotFoundException;

    T get(int id) throws EntityNotFoundException;

    List<T> getAll();
}

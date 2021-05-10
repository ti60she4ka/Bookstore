package eu.senla.services;

import eu.senla.api.repositories.AbstractRepository;
import eu.senla.api.services.AbstractService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.BaseEntity;
import eu.senla.repositories.AbstractRepositoryImpl;

import java.util.List;


public class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

    protected AbstractRepository<T> abstractRepository = new AbstractRepositoryImpl<>();

    @Override
    public void create(T entity) {
        abstractRepository.create(entity);
    }

    @Override
    public void update(T entity) {
        abstractRepository.update(entity);
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        abstractRepository.delete(id);
    }

    @Override
    public T get(int id) throws EntityNotFoundException {
        return abstractRepository.get(id);
    }

    @Override
    public List<T> getAll() {
        return abstractRepository.getAll();
    }
}

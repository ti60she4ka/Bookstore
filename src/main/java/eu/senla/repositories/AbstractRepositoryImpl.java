package eu.senla.repositories;

import eu.senla.api.data.AbstractDataStorage;
import eu.senla.api.repositories.AbstractRepository;
import eu.senla.data.AbstractDataStorageImpl;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.BaseEntity;

import java.util.List;


public class AbstractRepositoryImpl<T extends BaseEntity> implements AbstractRepository<T> {

    protected AbstractDataStorage<T> abstractDataStorage = new AbstractDataStorageImpl<>();

    @Override
    public void create(T entity) {
        entity.setId(abstractDataStorage.getEntityIdSequence());
        abstractDataStorage.getEntities().add(entity);
    }

    @Override
    public void update(T entity) {
        int index = abstractDataStorage.getEntities().indexOf(entity);
        abstractDataStorage.getEntities().set(index, entity);
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        T entityForDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(id));

        abstractDataStorage.getEntities().remove(entityForDelete);
    }

    @Override
    public T get(int id) throws EntityNotFoundException {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public List<T> getAll() {
        return abstractDataStorage.getEntities();
    }
}

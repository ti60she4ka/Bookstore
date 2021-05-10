package eu.senla.data;

import eu.senla.api.data.AbstractDataStorage;
import eu.senla.model.entities.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class AbstractDataStorageImpl<T extends BaseEntity> implements AbstractDataStorage<T> {
    private List<T> entities = new ArrayList<>();
    private long entityIdSequence;

    @Override
    public List<T> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    @Override
    public long getEntityIdSequence() {
        return entityIdSequence++;
    }
}

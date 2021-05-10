package eu.senla.api.data;

import eu.senla.model.entities.BaseEntity;

import java.util.List;

public interface AbstractDataStorage<T extends BaseEntity> {
    List<T> getEntities();

    void setEntities(List<T> entities);

    long getEntityIdSequence();
}

package eu.senla.data;

import eu.senla.api.data.RequestDataStorage;
import eu.senla.model.entities.Request;

public class RequestDataStorageImpl extends AbstractDataStorageImpl<Request> implements RequestDataStorage {
    private static RequestDataStorage instance;

    public static RequestDataStorage getInstance() {
        if (instance == null) {
            instance = new RequestDataStorageImpl();
        }
        return instance;
    }
}

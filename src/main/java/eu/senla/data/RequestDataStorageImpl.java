package eu.senla.data;

import eu.senla.api.data.RequestDataStorage;
import eu.senla.model.entities.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestDataStorageImpl extends AbstractDataStorageImpl<Request> implements RequestDataStorage {

}

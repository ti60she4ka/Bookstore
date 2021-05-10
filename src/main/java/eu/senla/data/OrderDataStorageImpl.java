package eu.senla.data;

import eu.senla.api.data.OrderDataStorage;
import eu.senla.model.entities.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDataStorageImpl extends AbstractDataStorageImpl<Order> implements OrderDataStorage {

}

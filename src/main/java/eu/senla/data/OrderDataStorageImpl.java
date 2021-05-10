package eu.senla.data;

import eu.senla.api.data.OrderDataStorage;
import eu.senla.model.entities.Order;

public class OrderDataStorageImpl extends AbstractDataStorageImpl<Order> implements OrderDataStorage {
    private static OrderDataStorage instance;

    public static OrderDataStorage getInstance(){
        if(instance == null){
            instance = new OrderDataStorageImpl();
        }
        return instance;
    }
}

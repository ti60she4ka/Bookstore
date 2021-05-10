package eu.senla.repositories;

import eu.senla.api.data.OrderDataStorage;
import eu.senla.api.repositories.OrderRepository;
import eu.senla.data.OrderDataStorageImpl;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Order;
import eu.senla.model.enums.status.OrderStatus;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {
    private static OrderRepository instance;
    private static OrderDataStorage orderDataStorage;

    public OrderRepositoryImpl(){
        super(OrderDataStorageImpl.getInstance());
        orderDataStorage = (OrderDataStorage) abstractDataStorage;
    }

    public static OrderRepository getInstance() {
        if(instance == null){
            instance = new OrderRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Order> getCompletedOrders() {
        return orderDataStorage.getEntities()
                .stream()
                .filter(order -> order.getStatus() == OrderStatus.COMPLETED)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getNewOrders() {
        return orderDataStorage.getEntities()
                .stream()
                .filter(order -> order.getStatus() == OrderStatus.NEW)
                .collect(Collectors.toList());
    }
}

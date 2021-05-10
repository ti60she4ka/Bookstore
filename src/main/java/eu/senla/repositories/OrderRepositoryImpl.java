package eu.senla.repositories;

import eu.senla.api.data.OrderDataStorage;
import eu.senla.api.repositories.OrderRepository;
import eu.senla.model.entities.Order;
import eu.senla.model.enums.status.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl extends AbstractRepositoryImpl<Order> implements OrderRepository {
    @Autowired
    private OrderDataStorage orderDataStorage;

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

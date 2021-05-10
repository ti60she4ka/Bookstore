package eu.senla.api.repositories;

import eu.senla.model.entities.Order;

import java.util.List;

public interface OrderRepository extends AbstractRepository<Order>{
    List<Order> getCompletedOrders();
    List<Order> getNewOrders();
}

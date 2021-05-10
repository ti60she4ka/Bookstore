package eu.senla.api.services;

import eu.senla.model.entities.Order;
import eu.senla.model.enums.sort.OrderSortType;

import java.time.LocalDate;
import java.util.List;

public interface OrderService extends AbstractService<Order>{
    List<Order> getSortedOrders(OrderSortType sortType);
    List<Order> getSortedCompletedOrders(OrderSortType sortType);
    Double getEarnedMoneyForTimePeriod(LocalDate date);
    Integer GetCountOfCompletedOrdersForTimePeriod(LocalDate date);
    List<Order> getNewOrders();
}

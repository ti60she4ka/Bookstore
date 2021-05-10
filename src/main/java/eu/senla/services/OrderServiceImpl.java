package eu.senla.services;

import eu.senla.api.repositories.OrderRepository;
import eu.senla.api.services.OrderService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Order;
import eu.senla.model.enums.sort.OrderSortType;
import eu.senla.repositories.OrderRepositoryImpl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl extends AbstractServiceImpl<Order> implements OrderService {
    private static OrderService instance;
    private static OrderRepository orderRepository;

    public OrderServiceImpl() {
        super(OrderRepositoryImpl.getInstance());
        orderRepository = (OrderRepository) abstractRepository;
    }

    public static OrderService getInstance() {
        if(instance == null){
            instance = new OrderServiceImpl();
        }
        return instance;
    }

    @Override
    public List<Order> getSortedOrders(OrderSortType sortType) {
        return sortOrders(sortType, orderRepository.getAll());
    }

    @Override
    public List<Order> getSortedCompletedOrders(OrderSortType sortType) {
        return sortOrders(sortType, orderRepository.getCompletedOrders());
    }

    private List<Order> sortOrders(OrderSortType sortType, List<Order> orders){
        switch (sortType) {
            case BY_EXECUTION_DATE: {
                return orders.stream()
                        .sorted(Comparator.comparing(Order::getExecutionDate))
                        .collect(Collectors.toList());
            }
            case BY_PRICE: {
                return orders.stream()
                        .sorted(Comparator.comparing(Order::getPrice))
                        .collect(Collectors.toList());
            }
            case BY_STATUS:{
                return orders.stream()
                        .sorted(Comparator.comparing(Order::getStatus))
                        .collect(Collectors.toList());
            }
            case BY_DELIVERY_DATE: {
                return orders.stream()
                        .sorted(Comparator.comparing(Order::getDeliveryDate))
                        .collect(Collectors.toList());
            }
        }

        return null;
    }

    @Override
    public Double getEarnedMoneyForTimePeriod(LocalDate date) {
        Double earnedMoney = (double) 0;
        List<Order> orders = orderRepository.getCompletedOrders()
                .stream()
                .filter(order -> order.getExecutionDate().isBefore(date))
                .collect(Collectors.toList());
        for (Order order : orderRepository.getCompletedOrders()){
            earnedMoney += order.getPrice();
        }
        return earnedMoney;
    }

    @Override
    public Integer GetCountOfCompletedOrdersForTimePeriod(LocalDate date) {
        List<Order> orders = orderRepository.getCompletedOrders()
                .stream()
                .filter(order -> order.getExecutionDate().isBefore(date))
                .collect(Collectors.toList());
        return orders.size();
    }

    @Override
    public List<Order> getNewOrders() {
        return orderRepository.getNewOrders();
    }
}

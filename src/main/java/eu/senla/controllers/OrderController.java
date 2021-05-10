package eu.senla.controllers;

import eu.senla.api.services.OrderService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Customer;
import eu.senla.model.entities.Order;
import eu.senla.model.enums.sort.OrderSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    public void createOrder(List<Book> books, Customer customer){
        Order order = new Order(books, customer);
        createOrder(order);
    }

    public void createOrder(Order order){
        orderService.create(order);
    }

    public void updateOrder(Order order){
        orderService.update(order);
    }

    public void delete(int id) throws EntityNotFoundException {
        orderService.delete(id);
    }

    public Order getOrder(int id) throws EntityNotFoundException {
        return orderService.get(id);
    }

    public List<Order> getOrders(){
        return orderService.getAll();
    }

    public List<Order> getSortedOrders(OrderSortType sortType){
        return orderService.getSortedOrders(sortType);
    }

    public Double getEarnedMoneyForTimePeriod(LocalDate date){
        return orderService.getEarnedMoneyForTimePeriod(date);
    }

    public Integer getCountOfCompletedOrdersForTimePeriod(LocalDate date){
        return orderService.GetCountOfCompletedOrdersForTimePeriod(date);
    }

    public List<Order> getNewOrders(){
        return orderService.getNewOrders();
    }
}

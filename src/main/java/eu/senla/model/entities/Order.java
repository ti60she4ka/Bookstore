package eu.senla.model.entities;

import eu.senla.model.enums.status.OrderStatus;

import java.time.LocalDate;
import java.util.List;

public class Order extends BaseEntity {
    private List<Book> books;
    private OrderStatus status;
    private LocalDate executionDate;
    private LocalDate deliveryDate;
    private Double price;
    private Customer customer;

    public Order(List<Book> books, Customer customer) {
        this.books = books;
        this.customer = customer;
        this.status = OrderStatus.NEW;
        this.deliveryDate = LocalDate.now();
    }

    public List<Book> getBook() {
        return books;
    }

    public void setBook(List<Book> books) {
        this.books = books;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getPrice() {
        if (price == null) {
            price = (double) 0;
            for (Book book : books) {
                price += book.getPrice();
            }
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder booksString = new StringBuilder();
        for (Book book : books) {
            booksString.append('\'').append(book.getName()).append("' ");
        }
        return "id заказа - " + getId() + '\n' +
                "\tКниги - " + booksString + '\n' +
                "\tСтатус - " + status + '\n' +
                "\tЦена - " + price + '\n' +
                "\tДата составления - " + deliveryDate + '\n' +
                "\tДата выполнения - " + executionDate + '\n' +
                '\t' + customer.toString() + '\n';
    }
}

package eu.senla.model.entities;

import eu.senla.model.enums.status.BookStatus;

import java.time.LocalDate;

public class Book extends BaseEntity{
    private String name;
    private BookStatus status;
    private LocalDate publicationDate;
    private LocalDate deliveryDate;
    private Double price;
    private String description;

    public Book(String name, BookStatus status, LocalDate publicationDate,
                LocalDate deliveryDate, double price, String description) {
        this.name = name;
        this.status = status;
        this.publicationDate = publicationDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "id книги - " + getId() + '\n' +
                "\tНазвание - \"" + name + "\"\n" +
                "\tДата издания - " + publicationDate + '\n' +
                "\tДата поступления - " + deliveryDate + '\n' +
                "\tЦена - " + price + '\n' +
                "\tНаличие на складе - " + status + '\n' +
                "\tОписание - " + description + '\n';
    }
}

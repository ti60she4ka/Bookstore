package eu.senla.model.entities;

import eu.senla.model.enums.status.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book extends BaseEntity{
    private String name;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private LocalDate publicationDate;
    private LocalDate deliveryDate;
    private Double price;
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    List<Request> requests = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    List<Booking> bookings = new ArrayList<>();

    public Book(String name, BookStatus status, LocalDate publicationDate,
                LocalDate deliveryDate, double price, String description) {
        this.name = name;
        this.status = status;
        this.publicationDate = publicationDate;
        this.deliveryDate = deliveryDate;
        this.price = price;
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

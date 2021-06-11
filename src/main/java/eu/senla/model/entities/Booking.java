package eu.senla.model.entities;

import eu.senla.model.enums.status.BookingStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Booking extends BaseEntity {
    @ManyToMany
    private List<Book> books;
    private BookingStatus status;
    private LocalDate executionDate;
    private LocalDate deliveryDate;
    private Double price;
    @ManyToOne
    private Customer customer;

    public Booking(List<Book> books, Customer customer) {
        this.books = books;
        this.customer = customer;
        this.status = BookingStatus.NEW;
        this.deliveryDate = LocalDate.now();
        books.forEach(book -> price += book.getPrice());
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

package eu.senla.dto;

import eu.senla.model.entities.Book;
import eu.senla.model.entities.Customer;
import eu.senla.model.enums.status.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BookingDto {
    private List<BookDto> books;
    private BookingStatus status;
    private LocalDate executionDate;
    private LocalDate deliveryDate;
    private Double price;
    private CustomerDto customer;
}

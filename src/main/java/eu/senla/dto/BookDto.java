package eu.senla.dto;

import eu.senla.model.enums.status.BookStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookDto {
    private String name;
    private BookStatus status;
    private LocalDate publicationDate;
    private LocalDate deliveryDate;
    private Double price;
    private String description;
}

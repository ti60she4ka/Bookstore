package eu.senla.initializers;

import eu.senla.controllers.BookController;
import eu.senla.model.enums.status.BookStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookInitializer implements Initializer{
    @Autowired
    private BookController bookController;

    @Override
    public void init() {
        LocalDate publicationDate;
        LocalDate deliveryDate;
        String description;

        publicationDate = LocalDate.of(1997,5,6);
        deliveryDate = LocalDate.of(2020,4,25);
        description = "Очень интересная книга";
        bookController.createBook("книга 1", BookStatus.IN_STOCK,
                publicationDate, deliveryDate,20.7, description);

        publicationDate = LocalDate.of(1996,6,25);
        deliveryDate = LocalDate.of(2020,4,26);
        description = "Очень интересная книга";
        bookController.createBook("книга 2", BookStatus.NOT_AVAILABLE,
                publicationDate, deliveryDate,21.5, description);

        publicationDate = LocalDate.of(1995,2,25);
        deliveryDate = LocalDate.of(2019,5,26);
        description = "Очень интересная книга";
        bookController.createBook("книга 3", BookStatus.IN_STOCK,
                publicationDate, deliveryDate,19.9, description);

        publicationDate = LocalDate.of(1996,5,15);
        deliveryDate = LocalDate.of(2021,3,28);
        description = "Очень интересная книга";
        bookController.createBook("книга 5", BookStatus.NOT_AVAILABLE,
                publicationDate, deliveryDate,20.5, description);

        publicationDate = LocalDate.of(1995,1,1);
        deliveryDate = LocalDate.of(2020,9,11);
        description = "Очень интересная книга";
        bookController.createBook("книга 4", BookStatus.IN_STOCK,
                publicationDate, deliveryDate,21.8, description);
    }
}

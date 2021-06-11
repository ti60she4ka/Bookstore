package eu.senla.api.repositories;

import eu.senla.model.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> getBooksByDeliveryDateBefore(LocalDate date);
    List<Book> findAll();
}

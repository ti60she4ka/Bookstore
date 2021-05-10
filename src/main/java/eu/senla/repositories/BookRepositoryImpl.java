package eu.senla.repositories;

import eu.senla.api.data.BookDataStorage;
import eu.senla.api.repositories.BookRepository;
import eu.senla.model.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl extends AbstractRepositoryImpl<Book> implements BookRepository {
    @Autowired
    private BookDataStorage bookDataStorage;

    @Override
    public List<Book> getStaleBooks() {
        return bookDataStorage.getEntities()
                .stream()
                .filter(book -> book.getDeliveryDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }
}

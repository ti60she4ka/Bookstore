package eu.senla.repositories;

import eu.senla.api.data.BookDataStorage;
import eu.senla.api.repositories.BookRepository;
import eu.senla.data.BookDataStorageImpl;
import eu.senla.model.entities.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl extends AbstractRepositoryImpl<Book> implements BookRepository {
    private static BookRepository instance;
    private static BookDataStorage bookDataStorage;

    public BookRepositoryImpl(){
        super(BookDataStorageImpl.getInstance());
        bookDataStorage = (BookDataStorage) abstractDataStorage;
    }

    public static BookRepository getInstance() {
        if(instance == null){
            instance = new BookRepositoryImpl();
        }
        return instance;
    }

    @Override
    public List<Book> getStaleBooks() {
        return bookDataStorage.getEntities()
                .stream()
                .filter(book -> book.getDeliveryDate().isBefore(LocalDate.now().minusMonths(6)))
                .collect(Collectors.toList());
    }
}

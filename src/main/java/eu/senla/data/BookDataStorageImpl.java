package eu.senla.data;

import eu.senla.api.data.BookDataStorage;
import eu.senla.model.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDataStorageImpl extends AbstractDataStorageImpl<Book> implements BookDataStorage {

}

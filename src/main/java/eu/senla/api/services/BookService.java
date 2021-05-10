package eu.senla.api.services;

import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;

import java.util.List;

public interface BookService extends AbstractService<Book> {
    List<Book> getSortedBooks(BookSortType sortType);
    List<Book> getSortedStaleBooks(BookSortType sortType);
}

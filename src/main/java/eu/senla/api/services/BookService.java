package eu.senla.api.services;

import eu.senla.dto.BookDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;
import eu.senla.model.enums.status.BookStatus;

import java.util.List;

public interface BookService {
    BookDto create(Book book);

    void update(Book book) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    BookDto get(Long id) throws EntityNotFoundException;

    List<BookDto> getAll();

    List<BookDto> getSortedBooks(BookSortType sortType);

    List<BookDto> getSortedStaleBooks(BookSortType sortType);

    void addBookToWarehouse(Long id) throws EntityNotFoundException;
}

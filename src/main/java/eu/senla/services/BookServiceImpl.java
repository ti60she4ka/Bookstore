package eu.senla.services;

import eu.senla.api.repositories.BookRepository;
import eu.senla.api.services.BookService;
import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends AbstractServiceImpl<Book> implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getSortedBooks(BookSortType sortType) {
        return sortBooks(sortType, bookRepository.getAll());
    }

    @Override
    public List<Book> getSortedStaleBooks(BookSortType sortType) {
        return sortBooks(sortType, bookRepository.getStaleBooks());
    }

    private List<Book> sortBooks(BookSortType sortType, List<Book> books){
        switch (sortType) {
            case BY_ALPHABET: {
                return books.stream()
                        .sorted(Comparator.comparing(book -> book.getName().toLowerCase()))
                        .collect(Collectors.toList());
            }
            case BY_PUBLICATION_DATE: {
                return books.stream()
                        .sorted(Comparator.comparing(Book::getPublicationDate))
                        .collect(Collectors.toList());
            }
            case BY_PRICE:{
                return books.stream()
                        .sorted(Comparator.comparing(Book::getPrice))
                        .collect(Collectors.toList());
            }
            case BY_STOCK_AVAILABILITY: {
                return books.stream()
                        .sorted(Comparator.comparing(Book::getStatus))
                        .collect(Collectors.toList());
            }
        }

        return null;
    }
}

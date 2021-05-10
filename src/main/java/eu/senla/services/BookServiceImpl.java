package eu.senla.services;

import eu.senla.api.repositories.BookRepository;
import eu.senla.api.services.BookService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;
import eu.senla.repositories.BookRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl extends AbstractServiceImpl<Book> implements BookService {
    private static BookService instance;
    private final BookRepository bookRepository;

    public BookServiceImpl() {
        super(BookRepositoryImpl.getInstance());
        bookRepository = (BookRepository) abstractRepository;
    }

    public static BookService getInstance() {
        if(instance == null){
            instance = new BookServiceImpl();
        }
        return instance;
    }


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

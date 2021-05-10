package eu.senla.controllers;

import eu.senla.api.services.BookService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;
import eu.senla.model.enums.status.BookStatus;
import eu.senla.services.BookServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class BookController {
    private static BookController instance;
    private static BookService bookService;

    public BookController(){
        bookService = BookServiceImpl.getInstance();
    }

    public static BookController getInstance() {
        if(instance == null){
            instance = new BookController();
        }
        return instance;
    }

    public void createBook(String name, BookStatus status, LocalDate publicationDate,
                           LocalDate deliveryDate, double price, String description) {
        Book book = new Book(name, status, publicationDate, deliveryDate, price, description);
        createBook(book);
    }

    public void createBook(Book book) {
        bookService.create(book);
    }

    public void updateBook(Book book){
        bookService.update(book);
    }

    public void deleteBook(int id) throws EntityNotFoundException {
        bookService.delete(id);
    }

    public Book getBook(int id) throws EntityNotFoundException {
        return bookService.get(id);
    }

    public List<Book> getBooks(){
        return  bookService.getAll();
    }

    public List<Book> getSortedBooks(BookSortType sortType){
        return bookService.getSortedBooks(sortType);
    }
}

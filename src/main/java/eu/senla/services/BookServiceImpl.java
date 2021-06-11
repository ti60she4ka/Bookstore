package eu.senla.services;

import eu.senla.api.repositories.BookRepository;
import eu.senla.api.repositories.RequestRepository;
import eu.senla.api.services.BookService;
import eu.senla.dto.BookDto;
import eu.senla.dto.BookingDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Booking;
import eu.senla.model.enums.sort.BookSortType;
import eu.senla.model.enums.status.BookStatus;
import net.bytebuddy.jar.asm.Type;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDto> getSortedBooks(BookSortType sortType) {
        return sortBooks(sortType, bookRepository.findAll());
    }

    @Override
    public List<BookDto> getSortedStaleBooks(BookSortType sortType) {
        LocalDate staleDate = LocalDate.now().minusMonths(6);
        return sortBooks(sortType, bookRepository.getBooksByDeliveryDateBefore(staleDate));
    }

    private List<BookDto> sortBooks(BookSortType sortType, List<Book> books){
        List<Book> sortedBooks = null;

        switch (sortType) {
            case BY_ALPHABET: {
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(book -> book.getName().toLowerCase()))
                        .collect(Collectors.toList());
            }
            case BY_PUBLICATION_DATE: {
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(Book::getPublicationDate))
                        .collect(Collectors.toList());
            }
            case BY_PRICE:{
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(Book::getPrice))
                        .collect(Collectors.toList());
            }
            case BY_STOCK_AVAILABILITY: {
                sortedBooks = books.stream()
                        .sorted(Comparator.comparing(Book::getStatus))
                        .collect(Collectors.toList());
            }
        }

        return modelMapper.map(sortedBooks, new TypeToken<List<BookDto>>(){}.getType());
    }

    public void addBookToWarehouse(Long id) throws EntityNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book", id));
        //requestRepository.deleteRequestsByBook(book);
        book.setStatus(BookStatus.IN_STOCK);
    }

    @Override
    public BookDto create(Book entity) {
        Book book = bookRepository.save(entity);
        return modelMapper.map(book, BookDto.class);
    }
    
    @Override
    public void update(Book entity) throws EntityNotFoundException {
        Long id = entity.getId();
        bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book", id));
        bookRepository.save(entity);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book", id));
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto get(Long id) throws EntityNotFoundException {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("book", id));
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public List<BookDto> getAll() {
        return modelMapper.map(bookRepository.findAll(), new TypeToken<List<BookDto>>(){}.getType());
    }
}

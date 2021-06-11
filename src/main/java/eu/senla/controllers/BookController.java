package eu.senla.controllers;

import eu.senla.api.services.BookService;
import eu.senla.controllers.response.ResponseBody;
import eu.senla.dto.BookDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.enums.sort.BookSortType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("create")
    public ResponseEntity<BookDto> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateBook(Book book) throws EntityNotFoundException {
        bookService.update(book);
        return ResponseBody.successOperation();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) throws EntityNotFoundException {
        bookService.delete(id);
        return ResponseBody.successOperation();
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBook(@PathVariable Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(bookService.get(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> getBooks(){
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("sort")
    public ResponseEntity<List<BookDto>> getSortedBooks(@RequestParam("key") BookSortType sortType){
        return new ResponseEntity<>(bookService.getSortedBooks(sortType), HttpStatus.OK);
    }

    @PostMapping("add/{id}")
    public ResponseEntity<?> addBookToWareHouse(@PathVariable Long id) throws EntityNotFoundException {
        bookService.addBookToWarehouse(id);
        return ResponseBody.successOperation();
    }
}

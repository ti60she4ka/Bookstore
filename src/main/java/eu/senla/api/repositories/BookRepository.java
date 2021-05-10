package eu.senla.api.repositories;

import eu.senla.model.entities.Book;

import java.util.List;

public interface BookRepository extends AbstractRepository<Book>{
    List<Book> getStaleBooks();
}

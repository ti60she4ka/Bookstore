package eu.senla.api.repositories;

import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;

public interface RequestRepository extends AbstractRepository<Request>{
    void deleteRequestsByBook(Book book);
}

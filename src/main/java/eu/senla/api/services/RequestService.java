package eu.senla.api.services;

import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;

public interface RequestService extends AbstractService<Request>{
    void deleteRequestsByBook(Book book);
}

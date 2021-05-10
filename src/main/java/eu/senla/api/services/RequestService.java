package eu.senla.api.services;

import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;

import java.util.List;

public interface RequestService extends AbstractService<Request>{
    void deleteRequestsByBook(Book book);
}

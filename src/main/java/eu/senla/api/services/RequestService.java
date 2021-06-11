package eu.senla.api.services;

import eu.senla.dto.BookDto;
import eu.senla.dto.RequestDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;

import java.util.List;

public interface RequestService {
    RequestDto create(Request request);

    void update(Request request) throws EntityNotFoundException;

    void delete(Long id) throws EntityNotFoundException;

    RequestDto get(Long id) throws EntityNotFoundException;

    List<RequestDto> getAll();

    void deleteRequestsByBook(Book book);
}

package eu.senla.services;

import eu.senla.api.repositories.RequestRepository;
import eu.senla.api.services.RequestService;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl extends AbstractServiceImpl<Request> implements RequestService {
    @Autowired
    private RequestRepository requestRepository;

    @Override
    public void deleteRequestsByBook(Book book) {
        requestRepository.deleteRequestsByBook(book);
    }
}

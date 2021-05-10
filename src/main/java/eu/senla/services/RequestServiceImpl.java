package eu.senla.services;

import eu.senla.api.repositories.RequestRepository;
import eu.senla.api.services.RequestService;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import eu.senla.repositories.RequestRepositoryImpl;

import java.util.List;

public class RequestServiceImpl extends AbstractServiceImpl<Request> implements RequestService {
    private static RequestService instance;
    private static RequestRepository requestRepository;

    public RequestServiceImpl() {
        super(RequestRepositoryImpl.getInstance());
        requestRepository = (RequestRepository) abstractRepository;
    }

    public static RequestService getInstance() {
        if (instance == null) {
            instance = new RequestServiceImpl();
        }
        return instance;
    }

    @Override
    public void deleteRequestsByBook(Book book) {
        requestRepository.deleteRequestsByBook(book);
    }
}

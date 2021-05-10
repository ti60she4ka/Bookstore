package eu.senla.repositories;

import eu.senla.api.data.RequestDataStorage;
import eu.senla.api.repositories.RequestRepository;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RequestRepositoryImpl extends AbstractRepositoryImpl<Request> implements RequestRepository {
    @Autowired
    private RequestDataStorage requestDataStorage;

    @Override
    public void deleteRequestsByBook(Book book) {
        requestDataStorage.getEntities()
                .removeIf(request -> request.getBook().equals(book));
    }
}

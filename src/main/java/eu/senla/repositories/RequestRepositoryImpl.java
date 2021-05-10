package eu.senla.repositories;

import eu.senla.api.data.RequestDataStorage;
import eu.senla.api.repositories.RequestRepository;
import eu.senla.data.RequestDataStorageImpl;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;

public class RequestRepositoryImpl extends AbstractRepositoryImpl<Request> implements RequestRepository {
    private static RequestRepository instance;
    private static RequestDataStorage requestDataStorage;

    public RequestRepositoryImpl(){
        super(RequestDataStorageImpl.getInstance());
        requestDataStorage = (RequestDataStorage) abstractDataStorage;
    }

    public static RequestRepository getInstance() {
        if(instance == null){
            instance = new RequestRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void deleteRequestsByBook(Book book) {
        requestDataStorage.getEntities()
                .removeIf(request -> request.getBook().equals(book));
    }
}

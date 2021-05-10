package eu.senla.data;

import eu.senla.api.data.BookDataStorage;
import eu.senla.model.entities.Book;

public class BookDataStorageImpl extends AbstractDataStorageImpl<Book> implements BookDataStorage {
    private static BookDataStorage instance;

    public static BookDataStorage getInstance(){
        if(instance == null){
            instance = new BookDataStorageImpl();
        }
        return instance;
    }
}

package eu.senla.initializers;

import eu.senla.data.BookDataStorageImpl;
import eu.senla.data.OrderDataStorageImpl;
import eu.senla.data.RequestDataStorageImpl;

import java.util.ArrayList;

public class DataStorageInitializer {
    public static void init(){
        BookDataStorageImpl.getInstance().setEntities(new ArrayList<>());
        OrderDataStorageImpl.getInstance().setEntities(new ArrayList<>());
        RequestDataStorageImpl.getInstance().setEntities(new ArrayList<>());
    }
}

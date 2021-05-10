package eu.senla.initializers;

public class MainInitializer {
    public static void init(){
        DataStorageInitializer.init();
        BookInitializer.init();
    }
}

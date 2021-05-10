package eu.senla.exceptions;

public class BookNotFoundException extends EntityNotFoundException{
    public BookNotFoundException(int id){
        super("Could not find book with ID = " + id);
    }
}

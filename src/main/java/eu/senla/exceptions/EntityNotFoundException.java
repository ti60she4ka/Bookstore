package eu.senla.exceptions;

public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(int id){
        super("Could not find entity with ID = " + id);
    }
    public EntityNotFoundException(String message){
        super(message);
    }
}

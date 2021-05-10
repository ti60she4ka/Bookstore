package eu.senla.exceptions;

public class RequestNotFoundException extends EntityNotFoundException{
    public RequestNotFoundException(int id){
        super("Could not find request with ID = " + id);
    }
}

package eu.senla.exceptions;

public class OrderNotFoundException extends EntityNotFoundException{
    public OrderNotFoundException(int id){
        super("Could not find order with ID = " + id);
    }
}

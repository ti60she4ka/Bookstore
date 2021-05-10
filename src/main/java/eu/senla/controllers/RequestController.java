package eu.senla.controllers;

import eu.senla.api.services.RequestService;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import eu.senla.services.RequestServiceImpl;

import java.util.List;

public class RequestController {
    private static RequestController instance;
    private final RequestService requestService;

    public RequestController() {
        requestService = RequestServiceImpl.getInstance();
    }

    public static RequestController getInstance() {
        if(instance == null){
            instance = new RequestController();
        }
        return instance;
    }

    public void createRequest(Book book){
        Request request = new Request(book);
        createRequest(request);
    }

    public void createRequest(Request request){
        requestService.create(request);
    }

    public void updateRequest(Request request){
        requestService.update(request);
    }

    public void deleteRequest(int id) throws EntityNotFoundException {
        requestService.delete(id);
    }

    public Request getRequest(int id) throws EntityNotFoundException {
        return requestService.get(id);
    }

    public List<Request> getRequests(){
        return requestService.getAll();
    }

    public void deleteRequestsByBook(Book book){
        requestService.deleteRequestsByBook(book);
    }
}

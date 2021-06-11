package eu.senla.controllers;

import eu.senla.api.services.RequestService;
import eu.senla.controllers.response.ResponseBody;
import eu.senla.dto.RequestDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @PostMapping("create")
    public ResponseEntity<RequestDto> createRequest(@RequestBody Request request){
        return new ResponseEntity<>(requestService.create(request), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateRequest(Request request) throws EntityNotFoundException {
        requestService.update(request);
        return ResponseBody.successOperation();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long id) throws EntityNotFoundException {
        requestService.delete(id);
        return ResponseBody.successOperation();
    }

    @GetMapping("{id}")
    public ResponseEntity<RequestDto> getRequest(@PathVariable Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(requestService.get(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<RequestDto>> getRequests(){
        return new ResponseEntity<>(requestService.getAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteRequestsByBook(Book book){
        requestService.deleteRequestsByBook(book);
        return ResponseBody.successOperation();
    }
}

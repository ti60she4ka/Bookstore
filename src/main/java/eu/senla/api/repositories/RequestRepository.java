package eu.senla.api.repositories;

import eu.senla.model.entities.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<Request, Long> {
    //void deleteRequestsByBook(Book book);
    List<Request> findAll();
}

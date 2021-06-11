package eu.senla.services;

import eu.senla.api.repositories.RequestRepository;
import eu.senla.api.services.RequestService;
import eu.senla.dto.BookDto;
import eu.senla.dto.RequestDto;
import eu.senla.exceptions.EntityNotFoundException;
import eu.senla.model.entities.Book;
import eu.senla.model.entities.Request;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RequestDto create(Request entity) {
        Request request = requestRepository.save(entity);
        return modelMapper.map(request, RequestDto.class);
    }

    @Override
    public void update(Request entity) throws EntityNotFoundException {
        Long id = entity.getId();
        requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("request", id));
        requestRepository.save(entity);
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("request", id));
        requestRepository.deleteById(id);
    }

    @Override
    public RequestDto get(Long id) throws EntityNotFoundException {
        Request request = requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("request", id));
        return modelMapper.map(request, RequestDto.class);
    }

    @Override
    public List<RequestDto> getAll() {
        return modelMapper.map(requestRepository.findAll(), new TypeToken<List<RequestDto>>(){}.getType());
    }

    @Override
    public void deleteRequestsByBook(Book book) {
        //requestRepository.deleteRequestsByBook(book);
    }
}

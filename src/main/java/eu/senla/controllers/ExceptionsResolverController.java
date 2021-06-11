package eu.senla.controllers;

import eu.senla.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsResolverController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {
        String message = "Could not find " + ex.getEntityType() + " with ID = " + ex.getId();
        return handleExceptionInternal(ex, buildErrorResponseBody("Not found", message),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private Map<String, String> buildErrorResponseBody(String errorTitle, String message) {
        return new HashMap<String, String>() {{
            put("error", errorTitle);
            put("message", message);
        }};
    }
}

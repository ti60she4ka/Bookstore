package eu.senla.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;

@AllArgsConstructor
@Getter
public class EntityNotFoundException extends Exception {
    String entityType;
    Long id;

    @Override
    public String getMessage() {
        return "Entity was not found for the specified parameters";
    }
}

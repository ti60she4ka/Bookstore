package eu.senla.initializers;

import eu.senla.controllers.RequestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RequestInitializer implements Initializer{
    @Autowired
    private RequestController requestController;

    @Override
    public void init() {

    }
}

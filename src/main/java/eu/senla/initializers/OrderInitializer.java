package eu.senla.initializers;

import eu.senla.controllers.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderInitializer implements Initializer{
    @Autowired
    private OrderController orderController;

    @Override
    public void init() {

    }
}

package eu.senla.main;

import eu.senla.initializers.BookInitializer;
import eu.senla.initializers.Initializer;
import eu.senla.initializers.OrderInitializer;
import eu.senla.initializers.RequestInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataInitializer {
    @Autowired
    private BookInitializer bookInitializer;

    @Autowired
    private OrderInitializer orderInitializer;

    @Autowired
    private RequestInitializer requestInitializer;

    @Bean
    public void init(){
        List<Initializer> initializers = Arrays.asList(
                bookInitializer,
                orderInitializer,
                requestInitializer
        );

        initializers.forEach(Initializer::init);
    }
}

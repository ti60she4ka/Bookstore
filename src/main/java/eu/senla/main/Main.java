package eu.senla.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan("eu.senla")
public class Main {
    public static void main(String[] args) {
        Arrays.stream(SpringApplication.run(Main.class, args).getBeanDefinitionNames())
                .forEach(e -> System.out.println(e));
    }
}

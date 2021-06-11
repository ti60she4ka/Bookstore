package eu.senla.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer extends BaseEntity{
    private String firstName;
    private String secondName;
    private Integer age;

    @OneToMany(fetch = FetchType.LAZY)
    List<Booking> bookings = new ArrayList<>();

    public Customer(String firstName, String secondName, int age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Информация о покупателе: " +"Имя - " + firstName +" Фамилия - " + secondName + " Возраст - " + age + '\n';
    }
}

package eu.senla.model.entities;

public class Customer extends BaseEntity{
    private String firstName;
    private String secondName;
    private int age;

    public Customer(String firstName, String secondName, int age){
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Информация о покупателе: " +"Имя - " + firstName +" Фамилия - " + secondName + " Возраст - " + age + '\n';
    }
}

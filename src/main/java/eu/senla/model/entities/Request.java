package eu.senla.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Request extends BaseEntity{
    @ManyToOne
    private Book book;

    public Request(Book book){
        this.book = book;
    }

}

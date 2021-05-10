package eu.senla.model.entities;

public class Request extends BaseEntity{
    private Book book;

    public Request(Book book){
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

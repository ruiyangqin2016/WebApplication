package psu.edu.bookstore.model;

import lombok.Data;
//import psu.edu.bookstore.model.bookFile.DateTime;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_seq")
    @SequenceGenerator(name = "book_id_seq", sequenceName = "book_id_seq", allocationSize = 100)
    private Long bookId;

    private String title;
    private String isbn;
    private String author;
    private Date datePublished;
    private String genre;
    private Double price;

    public Book(){

    }

    public Book(String title, String isbn, String author, Date datePublished, String genre, Double price) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.datePublished = datePublished;
        this.genre = genre;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", author='" + author + '\'' +
                ", datePublished=" + datePublished +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}

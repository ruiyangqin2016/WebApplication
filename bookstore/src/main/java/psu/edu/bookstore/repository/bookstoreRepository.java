package psu.edu.bookstore.repository;

//import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.model.Book;

import java.util.List;

public interface bookstoreRepository {

    List<Book> findAllBooks();
//    Book searchBookByTitle(String title);
//    Book searchBookByAuthor(String author);
    Book findBookByID(Long bookID);

    Book addBook(String title, String ISBN, String author, String datePublished, String genre, Double price);

    Book editBook(Long bookID, String title, String ISBN, String author, String datePublished, String genre, Double price);

    List<Book> findAllBooksFiltered(String filterName);

    void deleteBook(Long bookID);

}

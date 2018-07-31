package psu.edu.bookstore.service;

//import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.model.Book;

import java.util.List;

public interface bookService {

    List<Book> findAllBooks();

//    Book searchBookByTitle(String title);
//
//    Book searchBookByAuthor(String author);

    Book findBookByID(Long bookID);

    List<Book> findAllBooksFiltered(String filterName);

    Book addBook(String title, String ISBN, String author, String datePublished, String genre, String price);

    void deleteBook(Long bookID);

    Book editBook(Long bookID, String title, String ISBN, String author, String datePublished, String genre, Double price);
}

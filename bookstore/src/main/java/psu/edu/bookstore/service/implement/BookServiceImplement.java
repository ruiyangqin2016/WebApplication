package psu.edu.bookstore.service.implement;

import psu.edu.bookstore.model.Book;
//import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.repository.bookstoreRepository;
import psu.edu.bookstore.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements bookService {

    @Autowired
    private bookstoreRepository bookstoreRepository;

    @Override
    public List<Book> findAllBooks(){
        return bookstoreRepository.findAllBooks();
    }

/*
    @Override
    public Book searchBookByTitle(String title){
        return bookstoreRepository.searchBookByTitle(title);
    }

    @Override
    public Book searchBookByAuthor(String author){
        return bookstoreRepository.searchBookByAuthor(author);
    }
*/

    @Override
    public List<Book> findAllBooksFiltered(String filterName){
        return bookstoreRepository.findAllBooksFiltered(filterName);
    }

    @Override
    public Book findBookByID(Long bookID) {
        return bookstoreRepository.findBookByID(bookID);
    }

    @Override
    public Book addBook(String title, String ISBN, String author, String datePublished, String genre, String price){
//        DateTime a;
//        String arrDate[]  = datePublished.split("/");
//        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
        return bookstoreRepository.addBook(title, ISBN, author, datePublished, genre, Double.parseDouble(price));
    }

    @Override
    public Book editBook(Long bookID, String title, String ISBN, String author, String datePublished, String genre, Double price){
        return bookstoreRepository.editBook(bookID, title, ISBN, author, datePublished, genre, price);
    }

    @Override
    public void deleteBook(Long bookID){
        bookstoreRepository.deleteBook(bookID);
    }

//    @Override
//    public Book searchBookByTitle(String title){return bookstoreRepository.searchBookByTitle(title);}
//
//    @Override
//    public Book searchBookByAuthor(String author){return bookstoreRepository.searchBookByAuthor(author);}
}

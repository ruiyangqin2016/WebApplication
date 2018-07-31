package psu.edu.bookstore.jpa;

import org.springframework.data.repository.CrudRepository;
import psu.edu.bookstore.model.Book;

import java.util.List;

public interface BookCrudRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String filterName);
    List<Book> findByAuthor(String filterName);
}

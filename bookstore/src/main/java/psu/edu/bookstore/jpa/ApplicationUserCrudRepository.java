package psu.edu.bookstore.jpa;

import org.springframework.data.repository.CrudRepository;
import psu.edu.bookstore.model.BookstoreUser;

public interface ApplicationUserCrudRepository extends CrudRepository<BookstoreUser, Long> {
    BookstoreUser findByUsername(String username);
}

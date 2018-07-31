package psu.edu.bookstore.service.implement;

import psu.edu.bookstore.model.BookstoreUser;

public interface ApplicationUserService {
    BookstoreUser findUserByUsername(String username);
}

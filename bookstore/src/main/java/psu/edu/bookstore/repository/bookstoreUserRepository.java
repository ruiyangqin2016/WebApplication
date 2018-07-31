package psu.edu.bookstore.repository;

import psu.edu.bookstore.model.BookstoreUser;

public interface bookstoreUserRepository {

    BookstoreUser findUserByUserName(String username);
    BookstoreUser addUser(String username, String password, Boolean admin);

}

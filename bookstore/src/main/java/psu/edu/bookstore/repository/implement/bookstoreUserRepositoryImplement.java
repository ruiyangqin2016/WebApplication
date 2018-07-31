package psu.edu.bookstore.repository.implement;

import org.springframework.beans.factory.annotation.Autowired;
import psu.edu.bookstore.jpa.ApplicationUserCrudRepository;
import psu.edu.bookstore.model.BookstoreUser;
import psu.edu.bookstore.repository.bookstoreUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class bookstoreUserRepositoryImplement implements bookstoreUserRepository {

/*
    private List<BookstoreUser> bookstoreUserList = new ArrayList<>();
*/

    @Autowired
    private ApplicationUserCrudRepository applicationUserCrudRepository;


    @Override
    public BookstoreUser findUserByUserName(String username){

        return applicationUserCrudRepository.findByUsername(username);
    }

    @Override
    public BookstoreUser addUser(String username, String password, Boolean isAdmin){
        BookstoreUser user = new BookstoreUser(username, password, isAdmin);

        return applicationUserCrudRepository.save(user);
    }
}

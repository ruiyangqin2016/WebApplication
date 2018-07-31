package psu.edu.bookstore.service.implement;


import psu.edu.bookstore.model.BookstoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserServiceImplement implements ApplicationUserService {

    @Autowired
    private psu.edu.bookstore.repository.bookstoreUserRepository bookstoreUserRepository;

    @Override
    public BookstoreUser findUserByUsername(String username){
        return bookstoreUserRepository.findUserByUserName(username);
    }

}

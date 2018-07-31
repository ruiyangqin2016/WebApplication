package psu.edu.bookstore.service;


import psu.edu.bookstore.model.BookstoreUser;
import psu.edu.bookstore.model.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import psu.edu.bookstore.service.implement.ApplicationUserService;

@Repository
public class bookstoreUserDetailsService implements UserDetailsService{

    @Autowired
    private ApplicationUserService bookstoreUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        BookstoreUser user = bookstoreUserService.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Username not found: " + username);
        }
        return new SecurityUser(user);
    }
}

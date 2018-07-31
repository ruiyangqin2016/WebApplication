package psu.edu.bookstore.bookstrap;

//import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.repository.bookstoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private psu.edu.bookstore.repository.bookstoreUserRepository bookstoreUserRepository;

    @Autowired
    private bookstoreRepository bookstoreRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        bookstoreUserRepository.addUser("rxq5031","abcdQRY#5741",Boolean.FALSE);
        bookstoreUserRepository.addUser("user", "1234", Boolean.FALSE);
        bookstoreUserRepository.addUser("mark", "zuckerberg", Boolean.FALSE);
        bookstoreUserRepository.addUser("admin","12345",Boolean.TRUE);

//        DateTime a1 = new DateTime(10,1,1993);
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        String a1 = "10/01/1993";
        bookstoreRepository.addBook("The Giver", "1385732554", "Lois Lowry", a1, "fiction",6.99);
//        DateTime a2 = new DateTime(8,17,1945);
        String a2 = "08/17/1945";
        bookstoreRepository.addBook("Animal Farm", "1943138427", "George Orwell", a2, "fiction",7.83);
//        DateTime a3 = new DateTime(5,27,1967);
        String a3 = "05/27/1967";
        bookstoreRepository.addBook("Game of Thrones", "1343091277", "George R.R. Martin", a3, "fiction",40.00);
    }
}

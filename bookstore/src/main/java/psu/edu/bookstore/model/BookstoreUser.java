package psu.edu.bookstore.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookstoreUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookstore_user_id_seq")
    @SequenceGenerator(name = "bookstore_user_id_seq", sequenceName = "bookstore_user_id_seq", allocationSize = 100)
    protected Long id;

    protected String username;
    protected String password;
    protected Boolean isAdmin;

    public BookstoreUser(){
    }

    public BookstoreUser(String username, String password, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "BookstoreUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idAdmin=" + isAdmin +
                '}';
    }
}

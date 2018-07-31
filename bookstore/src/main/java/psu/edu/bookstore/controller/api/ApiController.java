package psu.edu.bookstore.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import psu.edu.bookstore.model.Book;
import psu.edu.bookstore.service.bookService;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private bookService bookService;

    @GetMapping("/api/books")
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }
}

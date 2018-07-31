package psu.edu.bookstore.controller;

import psu.edu.bookstore.model.Book;
//import psu.edu.bookstore.model.bookFile.DateTime;
import psu.edu.bookstore.service.bookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private bookService bookService;

    @GetMapping(value = "/")
    public String indexPage(Model model){
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @PostMapping(value = "/")
    public String filteredIndexPage(@RequestParam String filterName, Model model){
        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList",bookList);
        return "index";
    }

    @GetMapping(value = "/admin/bookstore/view")
    public String addViewPage(Model model){
        List<Book> bookList = bookService.findAllBooks();
        model.addAttribute("bookList",bookList);
        return "view";
    }

    @PostMapping(value = "/admin/bookstore/view")
    public String addViewForm(@RequestParam String filterName, Model model){
        List<Book> bookList = bookService.findAllBooksFiltered(filterName);
        model.addAttribute("bookList",bookList);
        return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/add")
    public String addBookPage(){
        return "addbook";
    }

    @PostMapping(value = "/admin/bookstore/add")
    public String addBookForm(@RequestParam String title, @RequestParam String isbn, @RequestParam String author, @RequestParam String datePublished, @RequestParam String Genre, @RequestParam String price){

        bookService.addBook(title, isbn, author, datePublished, Genre, price);
        return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/edit/{bookID}")
    public String editBookPage(@PathVariable(value = "bookID") Long bookID, Model model){
        if(bookID <=0||bookID==null){
            throw new IllegalStateException("Book ID is required!");
        }
        Book Book = bookService.findBookByID(bookID);
        if(Book != null){
            model.addAttribute("bookId", Book.getBookId());
            model.addAttribute("title", Book.getTitle());
            model.addAttribute("isbn", Book.getIsbn());
            model.addAttribute("author", Book.getAuthor());
            model.addAttribute("datePublished", Book.getDatePublished().toString());
            model.addAttribute("Genre", Book.getGenre());
            model.addAttribute("price", Book.getPrice());
        }
        return "editbook";
    }

    @PostMapping(value = "/admin/bookstore/edit")
    public String editBookPage(@RequestParam Long bookID, @RequestParam String title, @RequestParam String ISBN, @RequestParam String author, @RequestParam String datePublished, @RequestParam String Genre, @RequestParam Double price){
         if(bookID==null||bookID<=0){
             throw new IllegalStateException("Book ID is required!");
         }

//        DateTime a;
//        String arrDate[]  = datePublished.split("/");
//        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
         Book Book = bookService.editBook(bookID, title, ISBN, author, datePublished, Genre, price);
         log.debug("Book edit successful with ID " + Book.getBookId());
         return "redirect:/";
    }

    @GetMapping(value = "/admin/bookstore/delete/{bookID}")
    public String deleteBook(@PathVariable(value = "bookID") Long bookID){
        if(bookID==null||bookID<=0){
            throw new IllegalStateException("Book ID is required!");
        }
        bookService.deleteBook(bookID);
        return "redirect:/";
    }
}

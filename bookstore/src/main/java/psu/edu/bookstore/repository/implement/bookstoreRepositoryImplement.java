package psu.edu.bookstore.repository.implement;

import org.springframework.beans.factory.annotation.Autowired;
import psu.edu.bookstore.jpa.BookCrudRepository;
import psu.edu.bookstore.model.Book;
import psu.edu.bookstore.repository.bookstoreRepository;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class bookstoreRepositoryImplement implements bookstoreRepository {

    private List<Book> books = new ArrayList<>();

    @Autowired
    private BookCrudRepository bookCrudRepository;


    @Override
    public List<Book> findAllBooks(){
        return (List<Book>)bookCrudRepository.findAll();
    }

//    @Override
//    public Book searchBookByTitle(String title){
//        return books.stream()
//                .filter(Book ->Book.getTitle().equals(title))
//                .collect(MoreCollectors.onlyElement());
//    }
//
//    @Override
//    public Book searchBookByAuthor(String author){
//        return books.stream()
//                .filter(Book -> Book.getAuthor().equals(author))
//                .collect(MoreCollectors.onlyElement());
//    }

    @Override
    public Book findBookByID(Long bookID) {
        return bookCrudRepository.findOne(bookID);
    }

    @Override
    public Book addBook(String title, String ISBN, String author, String datePublished, String genre, Double price){
//        DateTime a;
//        String arrDate[]  = datePublished.split("/");
//        a = new DateTime(Integer.parseInt(arrDate[0]),Integer.parseInt(arrDate[1]),Integer.parseInt(arrDate[2]));
//        String genreArr[]={"fiction", "satire", "drama", "action", "adventure", "romance",
//                "mystery", "horror", "travel", "children", "religion", "spirituality",
//                "science","history", "math", "anthology", "poetry", "comics", "art",
//                 "journal", "series", "biography", "autobiography", "fantasy"};
//        Genre genreEnumArr[]={Genre.fiction,Genre.satire,Genre.drama,Genre.action,Genre.adventure,Genre.romance,
//                Genre.mystery, Genre.horror,Genre.travel,Genre.children,Genre.religion,Genre.spirituality,
//                Genre.science, Genre.history,Genre.math,Genre.anthology,Genre.poetry,Genre.comics,Genre.art,
//                Genre.journal, Genre.series, Genre.biography, Genre.autobiography, Genre.fantasy};
//        Genre b = Genre.valueOf("wrong");
//        for(int i = 0; i < genreArr.length; i ++){
//            if(genreArr[i].equals(genreEnumArr[i].toString())){
//                b = genreEnumArr[i];
//            }
//        }
        DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
        Book toAdd = null;
        try{
            toAdd = new Book(title, ISBN, author, df.parse(datePublished), genre, price);
        }catch (Exception e){

        }
        return bookCrudRepository.save(toAdd);
    }

    @Override
    public Book editBook(Long bookID, String title, String ISBN, String author, String datePublished, String genre, Double price){
        Book newBook = bookCrudRepository.findOne(bookID);
        if(newBook == null) {
            return null;
        }else{
            newBook.setTitle(title);
            newBook.setIsbn(ISBN);
            newBook.setAuthor(author);
            DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
            try{
                newBook.setDatePublished(df.parse(datePublished));
            }catch (Exception e){
            }
            newBook.setGenre(genre);
            newBook.setPrice(price);
            return bookCrudRepository.save(newBook);
        }
    }

    @Override
    public List<Book> findAllBooksFiltered(String filterName){
        boolean title = false;
        for(int i = 0; i < ((List<Book>)bookCrudRepository.findAll()).size(); i++){
            if(filterName.equals(((List<Book>)bookCrudRepository.findAll()).get(i).getTitle())){
                title = true;
            }
        }
        if(title){
            return bookCrudRepository.findByTitle(filterName);
        }else{
            return bookCrudRepository.findByAuthor(filterName);
        }
    }

    @Override
    public void deleteBook(Long bookID){
        bookCrudRepository.delete(bookID);
    }
}

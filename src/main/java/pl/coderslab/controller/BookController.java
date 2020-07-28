package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

import java.util.Arrays;
import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    BookController(final BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(path = "/books", produces = "text/plain;charset=UTF-8")
   String getAllBooks(){
        List<Book> books = bookService.findAllBooks();
        return books.toString();
   }

    @GetMapping(path = "/ratingbooks", produces = "text/plain;charset=UTF-8")
    String getRatingList(@RequestParam("rating") int rating) {
        List<Book> books = bookService.getRatingList(rating);
        return books.toString();
    }


    @GetMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String getBook(@RequestParam("id") long bookId){

            Book book = bookService.findBookById(bookId);
            return book.toString();
    }

    // /book title=Ala ma kota&rating=5&description=Fajna książka
    @PostMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String addBook(
            @RequestParam("title") String title,
            @RequestParam("rating") int rating,
            @RequestParam("description") String description){

        Publisher publisher = new Publisher();
        publisher.setName("Proszyński i S-ka");




      Book book = bookService.addBook(title, rating, description, publisher);

      return book.toString();

    }

    // /book?id=1&title=nowy tytuł
    @PutMapping(path = "/book", produces = "text/plain;charset=UTF-8")
    String updateBook(
            @RequestParam("id") long bookId,
            @RequestParam("title") String newTitle){

        Book book = bookService.updateBook(bookId, newTitle);

        return book.toString();

    }
    // DELETE/book?id=1
    @DeleteMapping(path = "/book", produces = "text/plain;charset=UTF-8" )
    String removeBook(@RequestParam("id") long bookId){
        Book book = bookService.removeBook(bookId);
        return book.toString();
    }

}

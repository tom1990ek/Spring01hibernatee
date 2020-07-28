package pl.coderslab.controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;
@RestController
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    //create  /author?firstName=Adam&lastName=Mickiewicz
    @PostMapping(path = "/author", produces = "text/plain; charset=UTF-8")
    String addAuthor(@RequestParam("firstName") String firstName,
                     @RequestParam("lastName") String lastName){
        Author author = authorService.addAuthor(firstName, lastName);
        return author.toString();
    }
    //read  /author?id=1
    @GetMapping("/author")
    String findAuthorById(@RequestParam("id") long id){
        if(authorService.findAuthorById(id) != null) {
            Author author = authorService.findAuthorById(id);
            return author.toString();
        } else{
            return "Brak autora";
        }
    }
    //update /author?id=1&firstName=Kowal&lastName=Janowski
    @PutMapping("/author")
    String updateAuthor(@RequestParam("id") long id,
                        @RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName){
        if(authorService.findAuthorById(id) != null) {
            Author author = authorService.updateAuthor(id, firstName, lastName);
            return author.toString();
        } else {
            return "Brak autora";
        }
    }
    //delete /author?id=1
    @DeleteMapping("/author")
    String deleteAuthor(@RequestParam("id") long id){
        if(authorService.findAuthorById(id) != null) {
            Author author = authorService.deleteAuthor(id);
            return author.toString();
        } else {
            return "Brak autora";
        }
    }
}
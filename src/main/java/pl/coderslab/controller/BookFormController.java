package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.Book;

@Controller
class BookFormController {

    @GetMapping(path = "form/book", produces = "text/plain;charset=UTF-8")
    String showForm(Model model){
        Book book = new Book();
        model.addAttribute("book,", book);
        return "book/add";
    }
}

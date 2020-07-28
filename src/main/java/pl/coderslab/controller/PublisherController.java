package pl.coderslab.controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;
@RestController
public class PublisherController {
    private PublisherService publisherService;
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }
    //POST /publisher?name=Wydawnictwo
    @PostMapping(path = "/publisher", produces = "text/plain; charset=UTF-8")
    String addPublisher(@RequestParam("name") String name){
        return publisherService.addPublisher(name).toString();
    }
    //GET /publisher?id=1
    @GetMapping(path = "/publisher", produces = "text/plain; charset=UTF-8")
    String getPublisher(@RequestParam("id") long id){
        if(publisherService.getPublisher(id) != null) {
            return publisherService.getPublisher(id).toString();
        }else {
            return "Brak wydawcy.";
        }
    }
    //PUT /publisher?id=1
    @PutMapping(path = "/publisher", produces = "text/plain; charset = UTF-8")
    String updatePublisher(@RequestParam("id") long id,
                           @RequestParam("name") String name){
        if(publisherService.getPublisher(id) != null) {
            return publisherService.updatePublisher(id, name).toString();
        } else {
            return "Brak wydawcy";
        }
    }
    //DELETE /publisher?id=1
    @DeleteMapping(path = "/publisher", produces = "text/plain; charset=UTF-8")
    String deletePublisher(@RequestParam("id") long id){
        if(publisherService.getPublisher(id) != null) {
            return publisherService.deletePublisher(id).toString();
        } else {
            return "Brak wydawcy";
        }
    }
}
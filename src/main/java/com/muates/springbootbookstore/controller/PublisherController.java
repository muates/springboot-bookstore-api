package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping({"", "/"})
    public List<Publisher> getAllPublishers(){
        return  publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public Publisher getPublisherById(@PathVariable Long id){
        return publisherService.getPublisherById(id);
    }

    @PostMapping({"","/"})
    public void savePublisher(@RequestBody Publisher publisher){
        publisherService.savePublisher(publisher);
    }

    @PutMapping("/{id}")
    public void updatePublisherById(@PathVariable Long id, @RequestBody Publisher publisher){
        publisherService.updatePublisherById(id, publisher);
    }

    @DeleteMapping("/{id}")
    public void deletePublisherById(@PathVariable Long id){
        publisherService.deletePublisherById(id);
    }
}

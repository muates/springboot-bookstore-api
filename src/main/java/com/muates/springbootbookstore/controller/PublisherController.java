package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.dto.request.PublisherRequest;
import com.muates.springbootbookstore.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return ResponseEntity.ok(publisherService.getAllPublishers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id) {
        return ResponseEntity.ok(publisherService.getPublisherById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Publisher> savePublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = convertToPublisher(publisherRequest);
        return ResponseEntity.ok(publisherService.savePublisher(publisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePublisherById(@PathVariable Long id, @Valid @RequestBody Publisher publisher) {
        publisherService.updatePublisherById(id, publisher);
        return ResponseEntity.ok("Publisher is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok("Publisher is deleted");
    }

    private Publisher convertToPublisher(PublisherRequest publisherRequest) {
        return Publisher.builder()
                .name(publisherRequest.getName())
                .build();
    }
}

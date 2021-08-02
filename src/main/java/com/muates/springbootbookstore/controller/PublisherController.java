package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.dto.PublisherConverter;
import com.muates.springbootbookstore.dto.request.PublisherRequest;
import com.muates.springbootbookstore.dto.response.PublisherResponse;
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
    public ResponseEntity<List<PublisherResponse>> getAllPublishers() {
        List<Publisher> publisherList = publisherService.getAllPublishers();
        return ResponseEntity.ok(PublisherConverter.convertAllPublishersToPublisherResponses(publisherList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long id) {
        PublisherResponse publisherResponse = PublisherConverter.convertToPublisherResponse(publisherService.getPublisherById(id));
        return ResponseEntity.ok(publisherResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<PublisherResponse> savePublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher savedPublisher = publisherService.savePublisher(PublisherConverter.convertToPublisher(publisherRequest));
        return ResponseEntity.ok(PublisherConverter.convertToPublisherResponse(savedPublisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePublisherById(@PathVariable Long id, @Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = PublisherConverter.convertToPublisher(publisherRequest);
        publisherService.updatePublisherById(id, publisher);
        return ResponseEntity.ok("Publisher is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
        return ResponseEntity.ok("Publisher is deleted");
    }

}

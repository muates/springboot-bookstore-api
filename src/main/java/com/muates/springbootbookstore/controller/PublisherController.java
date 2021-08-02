package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.dto.request.PublisherRequest;
import com.muates.springbootbookstore.dto.response.PublisherResponse;
import com.muates.springbootbookstore.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        List<PublisherResponse> publisherResponses = publisherList.stream().map(publisher -> convertToPublisherResponse(publisher)).collect(Collectors.toList());
        return ResponseEntity.ok(publisherResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponse> getPublisherById(@PathVariable Long id) {
        PublisherResponse publisherResponse = convertToPublisherResponse(publisherService.getPublisherById(id));
        return ResponseEntity.ok(publisherResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<PublisherResponse> savePublisher(@Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher savedPublisher = publisherService.savePublisher(convertToPublisher(publisherRequest));
        return ResponseEntity.ok(convertToPublisherResponse(savedPublisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePublisherById(@PathVariable Long id, @Valid @RequestBody PublisherRequest publisherRequest) {
        Publisher publisher = convertToPublisher(publisherRequest);
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
                .id(publisherRequest.getId())
                .name(publisherRequest.getName())
                .build();
    }

    private PublisherResponse convertToPublisherResponse(Publisher publisher) {
        return PublisherResponse.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .build();
    }
}

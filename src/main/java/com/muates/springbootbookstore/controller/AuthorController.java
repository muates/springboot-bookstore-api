package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.dto.request.AuthorRequest;
import com.muates.springbootbookstore.dto.response.AuthorResponse;
import com.muates.springbootbookstore.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<AuthorResponse>> getAllAuthors() {
        List<Author> authorList = authorService.getAllAuthors();
        List<AuthorResponse> authorResponses = authorList.stream().map(author -> convertToAuthorResponse(author)).collect(Collectors.toList());
        return ResponseEntity.ok(authorResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        AuthorResponse authorResponse = convertToAuthorResponse(authorService.getAuthorById(id));
        return ResponseEntity.ok(authorResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AuthorResponse> saveAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        Author savedAuthor = authorService.saveAuthor(convertToAuthor(authorRequest));
        return ResponseEntity.ok(convertToAuthorResponse(savedAuthor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorById(@PathVariable Long id, @Valid @RequestBody AuthorRequest authorRequest) {
        Author author = convertToAuthor(authorRequest);
        authorService.updateAuthorById(id, author);
        return ResponseEntity.ok("Author is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Author is deleted");
    }

    private Author convertToAuthor(AuthorRequest authorRequest) {
        return Author.builder()
                .id(authorRequest.getId())
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .build();
    }

    private AuthorResponse convertToAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .books(author.getBooks())
                .build();
    }
}

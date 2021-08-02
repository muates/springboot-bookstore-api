package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.dto.AuthorConverter;
import com.muates.springbootbookstore.dto.request.AuthorRequest;
import com.muates.springbootbookstore.dto.response.AuthorResponse;
import com.muates.springbootbookstore.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return ResponseEntity.ok(AuthorConverter.getAllAuthorsToAuthorResponse(authorList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthorById(@PathVariable Long id) {
        AuthorResponse authorResponse = AuthorConverter.convertToAuthorResponse(authorService.getAuthorById(id));
        return ResponseEntity.ok(authorResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AuthorResponse> saveAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        Author savedAuthor = authorService.saveAuthor(AuthorConverter.convertToAuthor(authorRequest));
        return ResponseEntity.ok(AuthorConverter.convertToAuthorResponse(savedAuthor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorById(@PathVariable Long id, @Valid @RequestBody AuthorRequest authorRequest) {
        Author author = AuthorConverter.convertToAuthor(authorRequest);
        authorService.updateAuthorById(id, author);
        return ResponseEntity.ok("Author is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Author is deleted");
    }

}

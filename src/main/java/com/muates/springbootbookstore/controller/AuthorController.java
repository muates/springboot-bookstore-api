package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.dto.AuthorRequest;
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
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Author> saveAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        Author author = convertToAuthor(authorRequest);
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthorById(@PathVariable Long id, @Valid @RequestBody Author author) {
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
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .build();
    }
}

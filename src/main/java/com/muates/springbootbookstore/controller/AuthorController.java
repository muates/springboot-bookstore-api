package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping({"","/"})
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping({"","/"})
    public void saveAuthor(@RequestBody Author author){
        authorService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public void updateAuthorById(@PathVariable Long id, @RequestBody Author author){
        authorService.updateAuthorById(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
    }
}

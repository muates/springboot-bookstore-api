package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.dto.BookRequest;
import com.muates.springbootbookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookId(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping({"","/"})
    public ResponseEntity<Book> saveBook(@Valid @RequestBody BookRequest bookRequest){
        Book book = convertToBook(bookRequest);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Long id, @Valid @RequestBody Book book){
        bookService.updateBookById(id, book);
        return ResponseEntity.ok("Book is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book is deleted");
    }

    private Book convertToBook(BookRequest bookRequest){
        return Book.builder()
                .publisher(bookRequest.getPublisher())
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .isbn(bookRequest.getIsbn())
                .cost(bookRequest.getCost())
                .build();
    }
}

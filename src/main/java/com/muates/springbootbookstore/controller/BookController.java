package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.dto.BookConverter;
import com.muates.springbootbookstore.dto.request.BookRequest;
import com.muates.springbootbookstore.dto.response.BookResponse;
import com.muates.springbootbookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<Book> bookList = bookService.getAllBooks();
        return ResponseEntity.ok(BookConverter.convertAllBooksToBookResponse(bookList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookId(@PathVariable Long id) {
        BookResponse bookResponse = BookConverter.convertToBookResponse(bookService.getBookById(id));
        return ResponseEntity.ok(bookResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<BookResponse> saveBook(@Valid @RequestBody BookRequest bookRequest) {
        Book savedBook = bookService.saveBook(BookConverter.convertToBook(bookRequest));
        return ResponseEntity.ok(BookConverter.convertToBookResponse(savedBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest) {
        Book book = BookConverter.convertToBook(bookRequest);
        bookService.updateBookById(id, book);
        return ResponseEntity.ok("Book is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book is deleted");
    }

}

package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.dto.request.BookRequest;
import com.muates.springbootbookstore.dto.response.BookResponse;
import com.muates.springbootbookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        List<BookResponse> bookResponses = bookList.stream().map(book -> convertToBookResponse(book)).collect(Collectors.toList());
        return ResponseEntity.ok(bookResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookId(@PathVariable Long id) {
        BookResponse bookResponse = convertToBookResponse(bookService.getBookById(id));
        return ResponseEntity.ok(bookResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<BookResponse> saveBook(@Valid @RequestBody BookRequest bookRequest) {
        Book savedBook = bookService.saveBook(convertToBook(bookRequest));
        return ResponseEntity.ok(convertToBookResponse(savedBook));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBookById(@PathVariable Long id, @Valid @RequestBody BookRequest bookRequest) {
        Book book = convertToBook(bookRequest);
        bookService.updateBookById(id, book);
        return ResponseEntity.ok("Book is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book is deleted");
    }

    private Book convertToBook(BookRequest bookRequest) {
        return Book.builder()
                .id(bookRequest.getId())
                .publisher(bookRequest.getPublisher())
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .isbn(bookRequest.getIsbn())
                .cost(bookRequest.getCost())
                .build();
    }

    private BookResponse convertToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .cost(book.getCost())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .build();
    }
}

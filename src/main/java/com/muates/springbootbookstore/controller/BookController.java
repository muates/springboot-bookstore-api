package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"","/"})
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookId(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping({"","/"})
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public void updateBookById(@PathVariable Long id, @RequestBody Book book){
        bookService.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}

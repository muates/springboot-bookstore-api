package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, PublisherService publisherService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User does not found!"));
    }

    public Book saveBook(Book book){
        Publisher publisher = publisherService.getPublisherById(book.getPublisher().getId());
        Author author = authorService.getAuthorById(book.getAuthor().getId());
        book.setPublisher(publisher);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public void updateBookById(Long id, Book book){
        Book existBook = getBookById(id);

        if(existBook == null){
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existBook.setTitle(book.getTitle());
        existBook.setIsbn(book.getIsbn());
        existBook.setCost(book.getCost());

        bookRepository.save(existBook);
    }

    public void deleteBookById(Long id){
        Book book = getBookById(id);
        if(book != null){
            bookRepository.deleteById(id);
        }
    }
}

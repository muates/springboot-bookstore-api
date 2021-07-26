package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.getById(id);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
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
        bookRepository.deleteById(id);
    }
}

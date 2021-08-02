package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author does not found!"));
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthorById(Long id, Author author) {
        getAuthorById(id);
        authorRepository.save(author);
    }

    public void deleteAuthorById(Long id) {
        Author author = getAuthorById(id);
        if (author != null) {
            authorRepository.deleteById(id);
        }
    }
}

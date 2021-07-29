package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

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
        return authorRepository.getById(id);
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthorById(Long id, Author author) {
        Author existAuthor = getAuthorById(id);

        if (existAuthor == null) {
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existAuthor.setFirstName(author.getFirstName());
        existAuthor.setLastName(author.getLastName());

        authorRepository.save(existAuthor);
    }

    public void deleteAuthorById(Long id) {
        Author author = getAuthorById(id);
        if (author != null) {
            authorRepository.deleteById(id);
        }
    }
}

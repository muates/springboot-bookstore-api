package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Publisher;
import com.muates.springbootbookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User does not found!"));
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public void updatePublisherById(Long id, Publisher publisher) {
        Publisher existPublisher = getPublisherById(id);

        if (existPublisher == null) {
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existPublisher.setName(publisher.getName());

        publisherRepository.save(existPublisher);
    }

    public void deletePublisherById(Long id) {
        Publisher publisher = getPublisherById(id);
        if (publisher != null) {
            publisherRepository.deleteById(id);
        }
    }
}

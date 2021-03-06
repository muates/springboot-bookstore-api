package com.muates.springbootbookstore.repository;

import com.muates.springbootbookstore.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}

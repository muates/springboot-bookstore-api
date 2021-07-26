package com.muates.springbootbookstore.domain;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
@RequestMapping("/books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer isbn;

    private Integer cost;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    public Book() {
    }

    public Book(Long id, String title, Integer isbn, Integer cost, Author author, Publisher publisher) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.cost = cost;
        this.author = author;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(cost, book.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, cost);
    }
}

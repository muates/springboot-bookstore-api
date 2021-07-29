package com.muates.springbootbookstore.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name = "books")
@RequestMapping("/books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer isbn;

    private Integer cost;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonBackReference
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonBackReference
    private Publisher publisher;

}

package com.muates.springbootbookstore.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer isbn;

    private Integer cost;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonManagedReference
    @ToString.Exclude
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonManagedReference
    @ToString.Exclude
    private Publisher publisher;

}

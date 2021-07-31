package com.muates.springbootbookstore.domain;

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
    @ToString.Exclude
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @ToString.Exclude
    private Publisher publisher;

}

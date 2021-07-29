package com.muates.springbootbookstore.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
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
    @JsonManagedReference
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH})
    @JsonManagedReference
    private Publisher publisher;

}

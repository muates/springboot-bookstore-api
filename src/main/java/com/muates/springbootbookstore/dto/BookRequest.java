package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private Integer isbn;

    @NotNull
    private Integer cost;

    @NotNull
    private Author author;

    @NotNull
    private Publisher publisher;
}

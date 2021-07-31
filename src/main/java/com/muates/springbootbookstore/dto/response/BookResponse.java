package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {

    private Long id;
    private String title;
    private Integer isbn;
    private Integer cost;
    private Author author;
    private Publisher publisher;

}

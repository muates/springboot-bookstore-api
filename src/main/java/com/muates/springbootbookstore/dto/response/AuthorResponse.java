package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> books;
}

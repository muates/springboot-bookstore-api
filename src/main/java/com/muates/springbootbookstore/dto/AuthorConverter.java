package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Author;
import com.muates.springbootbookstore.dto.request.AuthorRequest;
import com.muates.springbootbookstore.dto.response.AuthorResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorConverter {

    public static Author convertToAuthor(AuthorRequest authorRequest) {
        return Author.builder()
                .id(authorRequest.getId())
                .firstName(authorRequest.getFirstName())
                .lastName(authorRequest.getLastName())
                .build();
    }

    public static AuthorResponse convertToAuthorResponse(Author author) {
        return AuthorResponse.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .books(author.getBooks())
                .build();
    }

    public static List<AuthorResponse> getAllAuthorsToAuthorResponse(List<Author> authorList) {
        return authorList.stream().map(AuthorConverter::convertToAuthorResponse).collect(Collectors.toList());
    }

}

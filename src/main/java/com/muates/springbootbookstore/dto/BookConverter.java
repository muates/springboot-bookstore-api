package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Book;
import com.muates.springbootbookstore.dto.request.BookRequest;
import com.muates.springbootbookstore.dto.response.BookResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BookConverter {

    public static Book convertToBook(BookRequest bookRequest) {
        return Book.builder()
                .id(bookRequest.getId())
                .publisher(bookRequest.getPublisher())
                .author(bookRequest.getAuthor())
                .title(bookRequest.getTitle())
                .isbn(bookRequest.getIsbn())
                .cost(bookRequest.getCost())
                .build();
    }

    public static BookResponse convertToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .cost(book.getCost())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .build();
    }

    public static List<BookResponse> convertAllBooksToBookResponse(List<Book> bookList) {
        return bookList.stream().map(BookConverter::convertToBookResponse).collect(Collectors.toList());
    }

}

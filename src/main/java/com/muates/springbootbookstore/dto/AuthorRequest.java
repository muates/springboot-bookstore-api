package com.muates.springbootbookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
}

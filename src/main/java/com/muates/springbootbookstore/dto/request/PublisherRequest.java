package com.muates.springbootbookstore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherRequest {
    private Long id;

    @NotBlank
    private String name;
}

package com.muates.springbootbookstore.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenderRequest {
    private Long id;

    @NotBlank
    private String gender;
}

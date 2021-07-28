package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {
    private Long id;

    @NotBlank
    private String cityName;

    @NotNull
    private Country country;
}

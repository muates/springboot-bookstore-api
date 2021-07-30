package com.muates.springbootbookstore.dto.request;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
    private int id;

    @NotNull
    private Country country;

    @NotNull
    private City city;

    @NotBlank
    private String street;

    @NotBlank
    private String postCode;

}

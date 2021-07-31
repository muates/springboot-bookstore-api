package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressResponse {

    private Long id;
    private Country country;
    private City city;
    private String street;
    private String postCode;

}

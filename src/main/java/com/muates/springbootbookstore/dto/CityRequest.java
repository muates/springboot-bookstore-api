package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest {

    private Long id;

    private String cityName;

    private Country country;
}

package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryResponse {

    private Long id;
    private String countryName;
    private List<City> cityList;

}

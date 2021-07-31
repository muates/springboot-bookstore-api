package com.muates.springbootbookstore.dto.response;

import com.muates.springbootbookstore.domain.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityResponse {

    private Long id;
    private String cityName;
    private Country country;
}

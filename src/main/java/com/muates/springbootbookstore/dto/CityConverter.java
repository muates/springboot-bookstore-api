package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.dto.request.CityRequest;
import com.muates.springbootbookstore.dto.response.CityResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CityConverter {

    public static City convertToCity(CityRequest cityRequest) {
        return City.builder()
                .id(cityRequest.getId())
                .cityName(cityRequest.getCityName())
                .country(cityRequest.getCountry())
                .build();
    }

    public static CityResponse convertToCityResponse(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .cityName(city.getCityName())
                .country(city.getCountry())
                .build();
    }

    public static List<CityResponse> convertAllCitiesToCityResponses(List<City> cityList) {
        return cityList.stream().map(CityConverter::convertToCityResponse).collect(Collectors.toList());
    }
}

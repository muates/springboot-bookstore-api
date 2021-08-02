package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.dto.request.CountryRequest;
import com.muates.springbootbookstore.dto.response.CountryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CountryConverter {

    public static Country convertToCountry(CountryRequest countryRequest) {
        return Country.builder()
                .id(countryRequest.getId())
                .countryName(countryRequest.getCountryName())
                .build();
    }

    public static CountryResponse convertToCountryResponse(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .countryName(country.getCountryName())
                .cityList(country.getCityList())
                .build();
    }

    public static List<CountryResponse> convertAllCountriesToCountryResponses(List<Country> countryList) {
        return countryList.stream().map(CountryConverter::convertToCountryResponse).collect(Collectors.toList());
    }

}

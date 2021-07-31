package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.dto.request.CountryRequest;
import com.muates.springbootbookstore.dto.response.CountryResponse;
import com.muates.springbootbookstore.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Country>> getAllCountries() {
        return ResponseEntity.ok(countryService.getAllCountries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable Long id) {
        CountryResponse countryResponse = convertToCountryResponse(countryService.getCountryById(id));
        return ResponseEntity.ok(countryResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CountryResponse> saveCountry(@Valid @RequestBody CountryRequest countryRequest) {
        Country savedCountry = countryService.saveCountry(convertToCountry(countryRequest));
        return ResponseEntity.ok(convertToCountryResponse(savedCountry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountryById(@PathVariable Long id, @Valid @RequestBody CountryRequest countryRequest) {
        Country country = convertToCountry(countryRequest);
        countryService.updateCountryById(id, country);
        return ResponseEntity.ok("Country is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
        return ResponseEntity.ok("Country is deleted");
    }

    public Country convertToCountry(CountryRequest countryRequest) {
        return Country.builder()
                .id(countryRequest.getId())
                .countryName(countryRequest.getCountryName())
                .build();
    }

    public CountryResponse convertToCountryResponse(Country country) {
        return CountryResponse.builder()
                .id(country.getId())
                .countryName(country.getCountryName())
                .cityList(country.getCityList())
                .build();
    }
}

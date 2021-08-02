package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.dto.CountryConverter;
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
    public ResponseEntity<List<CountryResponse>> getAllCountries() {
        List<Country> countryList = countryService.getAllCountries();
        return ResponseEntity.ok(CountryConverter.convertAllCountriesToCountryResponses(countryList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable Long id) {
        CountryResponse countryResponse = CountryConverter.convertToCountryResponse(countryService.getCountryById(id));
        return ResponseEntity.ok(countryResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CountryResponse> saveCountry(@Valid @RequestBody CountryRequest countryRequest) {
        Country savedCountry = countryService.saveCountry(CountryConverter.convertToCountry(countryRequest));
        return ResponseEntity.ok(CountryConverter.convertToCountryResponse(savedCountry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountryById(@PathVariable Long id, @Valid @RequestBody CountryRequest countryRequest) {
        Country country = CountryConverter.convertToCountry(countryRequest);
        countryService.updateCountryById(id, country);
        return ResponseEntity.ok("Country is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountryById(@PathVariable Long id) {
        countryService.deleteCountryById(id);
        return ResponseEntity.ok("Country is deleted");
    }

}

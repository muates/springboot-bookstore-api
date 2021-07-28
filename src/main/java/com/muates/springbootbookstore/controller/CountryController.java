package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.dto.CountryRequest;
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
    public ResponseEntity<Country> getCountryById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Country> saveCountry(@Valid @RequestBody CountryRequest countryRequest) {
        Country country = convertToCountry(countryRequest);
        return ResponseEntity.ok(countryService.saveCountry(country));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCountryById(@PathVariable Long id, @Valid @RequestBody Country country) {
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
                .countryName(countryRequest.getCountryName())
                .build();
    }
}

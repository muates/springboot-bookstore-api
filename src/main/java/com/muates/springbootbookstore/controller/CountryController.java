package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.service.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping({"","/"})
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id){
        return countryService.getCountryById(id);
    }

    @PostMapping({"","/"})
    public void saveCountry(@RequestBody Country country){
        countryService.saveCountry(country);
    }

    @PutMapping("/{id}")
    public void updateCountryById(@PathVariable Long id, @RequestBody Country country){
        countryService.updateCountryById(id, country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountryById(@PathVariable Long id){
        countryService.deleteCountryById(id);
    }
}

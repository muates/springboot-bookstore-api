package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country does not found!"));
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public void updateCountryById(Long id, Country country) {
        getCountryById(id);
        countryRepository.save(country);
    }

    public void deleteCountryById(Long id) {
        Country country = getCountryById(id);
        if (country == null) {
            throw new ResourceNotFoundException("Country does not found!");
        }
        countryRepository.deleteById(id);
    }
}

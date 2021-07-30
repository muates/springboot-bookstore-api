package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.repository.CountryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

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
        return countryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Country does not found!"));
    }

    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    public void updateCountryById(Long id, Country country) {
        Country existCountry = getCountryById(id);

        if (existCountry == null) {
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        countryRepository.save(country);
    }

    public void deleteCountryById(Long id) {
        Country country = getCountryById(id);
        if (country != null) {
            countryRepository.deleteById(id);
        }
    }
}

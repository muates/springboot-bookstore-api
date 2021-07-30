package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;
    private final CountryService countryService;

    public CityService(CityRepository cityRepository, CountryService countryService) {
        this.cityRepository = cityRepository;
        this.countryService = countryService;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User does not found!"));
    }

    public City saveCity(City city) {
        Country country = countryService.getCountryById(city.getCountry().getId());
        city.setCountry(country);
        return cityRepository.save(city);
    }

    public void updateCityById(Long id, City city) {
        City existCity = getCityById(id);

        if (existCity == null) {
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existCity.setCityName(city.getCityName());

        cityRepository.save(existCity);
    }

    public void deleteCityById(Long id) {
        City city = getCityById(id);
        if (city != null) {
            cityRepository.deleteById(id);
        }
    }
}

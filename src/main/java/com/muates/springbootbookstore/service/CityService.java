package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City does not found!"));
    }

    public City saveCity(City city) {
        Country country = countryService.getCountryById(city.getCountry().getId());
        city.setCountry(country);
        return cityRepository.save(city);
    }

    public void updateCityById(Long id, City city) {
        getCityById(id);
        cityRepository.save(city);
    }

    public void deleteCityById(Long id) {
        City city = getCityById(id);
        if (city != null) {
            cityRepository.deleteById(id);
        }
    }
}

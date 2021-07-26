package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

    public City getCityById(Long id){
        return cityRepository.getById(id);
    }

    public void saveCity(City city){
        cityRepository.save(city);
    }

    public void updateCityById(Long id, City city){
        City existCity = getCityById(id);

        if(existCity == null){
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existCity.setCityName(city.getCityName());

        cityRepository.save(existCity);
    }

    public void deleteCityById(Long id){
        cityRepository.deleteById(id);
    }
}

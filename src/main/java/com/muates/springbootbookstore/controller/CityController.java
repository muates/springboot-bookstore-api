package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping({"","/"})
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id){
        return cityService.getCityById(id);
    }

    @PostMapping({"","/"})
    public void saveCity(@RequestBody City city){
        cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public void updateCityById(@PathVariable Long id, @RequestBody City city){
        cityService.updateCityById(id, city);
    }

    @DeleteMapping("/{id}")
    public void deleteCityById(@PathVariable Long id){
        cityService.deleteCityById(id);
    }
}

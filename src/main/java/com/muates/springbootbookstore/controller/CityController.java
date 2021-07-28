package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.dto.CityRequest;
import com.muates.springbootbookstore.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<City>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<City> saveCity(@Valid @RequestBody CityRequest cityRequest) {
        City city = convertToCity(cityRequest);
        return ResponseEntity.ok(cityService.saveCity(city));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCityById(@PathVariable Long id, @Valid @RequestBody City city) {
        cityService.updateCityById(id, city);
        return ResponseEntity.ok("City is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
        return ResponseEntity.ok("City is deleted");
    }

    private City convertToCity(CityRequest cityRequest) {
        return City.builder()
                .cityName(cityRequest.getCityName())
                .country(cityRequest.getCountry())
                .build();
    }
}

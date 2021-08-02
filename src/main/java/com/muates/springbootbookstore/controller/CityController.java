package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.dto.CityConverter;
import com.muates.springbootbookstore.dto.request.CityRequest;
import com.muates.springbootbookstore.dto.response.CityResponse;
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
    public ResponseEntity<List<CityResponse>> getAllCities() {
        List<City> cityList = cityService.getAllCities();
        return ResponseEntity.ok(CityConverter.convertAllCitiesToCityResponses(cityList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long id) {
        CityResponse cityResponse = CityConverter.convertToCityResponse(cityService.getCityById(id));
        return ResponseEntity.ok(cityResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CityResponse> saveCity(@Valid @RequestBody CityRequest cityRequest) {
        City savedCity = cityService.saveCity(CityConverter.convertToCity(cityRequest));
        return ResponseEntity.ok(CityConverter.convertToCityResponse(savedCity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCityById(@PathVariable Long id, @Valid @RequestBody CityRequest cityRequest) {
        City city = CityConverter.convertToCity(cityRequest);
        cityService.updateCityById(id, city);
        return ResponseEntity.ok("City is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCityById(@PathVariable Long id) {
        cityService.deleteCityById(id);
        return ResponseEntity.ok("City is deleted");
    }

}

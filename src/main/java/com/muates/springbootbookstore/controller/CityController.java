package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.dto.request.CityRequest;
import com.muates.springbootbookstore.dto.response.CityResponse;
import com.muates.springbootbookstore.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
        List<CityResponse> cityResponses = cityList.stream().map(city -> convertToCityResponse(city)).collect(Collectors.toList());
        return ResponseEntity.ok(cityResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityResponse> getCityById(@PathVariable Long id) {
        CityResponse cityResponse = convertToCityResponse(cityService.getCityById(id));
        return ResponseEntity.ok(cityResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<CityResponse> saveCity(@Valid @RequestBody CityRequest cityRequest) {
        City savedCity = cityService.saveCity(convertToCity(cityRequest));
        return ResponseEntity.ok(convertToCityResponse(savedCity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCityById(@PathVariable Long id, @Valid @RequestBody CityRequest cityRequest) {
        City city = convertToCity(cityRequest);
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
                .id(cityRequest.getId())
                .cityName(cityRequest.getCityName())
                .country(cityRequest.getCountry())
                .build();
    }

    private CityResponse convertToCityResponse(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .cityName(city.getCityName())
                .country(city.getCountry())
                .build();
    }
}

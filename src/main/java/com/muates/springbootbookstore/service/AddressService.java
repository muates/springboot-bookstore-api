package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.exception.ResourceNotFoundException;
import com.muates.springbootbookstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;
    private final CountryService countryService;
    private final CityService cityService;

    public AddressService(AddressRepository addressRepository, CountryService countryService, CityService cityService) {
        this.addressRepository = addressRepository;
        this.countryService = countryService;
        this.cityService = cityService;
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id){
        return addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address does not found!"));
    }

    public Address saveAddress(Address address) {
        Country country = countryService.getCountryById(address.getCountry().getId());
        City city = cityService.getCityById(address.getCity().getId());
        address.setCountry(country);
        address.setCity(city);
        return addressRepository.save(address);
    }

    public void updateAddressById(Long id, Address address){

        getAddressById(id);
        addressRepository.save(address);
    }

    public void deleteAddressById(Long id) {
        Address address = getAddressById(id);
        if (address == null) {
            throw new ResourceNotFoundException("Address does not found!");
        }
        addressRepository.deleteById(id);
    }
}

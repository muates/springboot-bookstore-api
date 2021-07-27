package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.domain.City;
import com.muates.springbootbookstore.domain.Country;
import com.muates.springbootbookstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

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
        return addressRepository.getById(id);
    }

    public void saveAddress(Address address){
        Country country = countryService.getCountryById(address.getCountry().getId());
        City city = cityService.getCityById(address.getCity().getId());
        address.setCountry(country);
        address.setCity(city);
        addressRepository.save(address);
    }

    public void updateAddressById(Long id, Address address){

        Address existAddress = getAddressById(id);

        if(existAddress == null){
            throw new NoSuchElementException("User with id" + id + " does not found!");
        }

        existAddress.setCountry(address.getCountry());
        existAddress.setCity(address.getCity());
        existAddress.setStreet(address.getStreet());
        existAddress.setPostCode(address.getPostCode());

        addressRepository.save(existAddress);
    }

    public void deleteAddressById(Long id){
        addressRepository.deleteById(id);
    }
}

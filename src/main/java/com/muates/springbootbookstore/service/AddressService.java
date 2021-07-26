package com.muates.springbootbookstore.service;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(Long id){
        return addressRepository.getById(id);
    }

    public void saveAddress(Address address){
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

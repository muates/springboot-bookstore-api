package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.domain.AddressRequest;
import com.muates.springbootbookstore.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping({"", "/"})
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public  Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    @PostMapping({"", "/"})
    public void saveAddress(@Valid @RequestBody AddressRequest addressRequest){
        Address address = convertToAddress(addressRequest);
        addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public void updateAddressById(@PathVariable Long id, @Valid @RequestBody Address address){
        addressService.updateAddressById(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id){
        addressService.deleteAddressById(id);
    }

    private Address convertToAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setCountry(addressRequest.getCountry());
        address.setCity(addressRequest.getCity());
        address.setStreet(addressRequest.getStreet());
        address.setPostCode(addressRequest.getPostCode());
        return address;
    }
}

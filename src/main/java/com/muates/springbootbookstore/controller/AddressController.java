package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.service.AddressService;
import org.springframework.web.bind.annotation.*;

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
    public void saveAddress(@RequestBody Address address){
        addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public void updateAddressById(@PathVariable Long id, @RequestBody Address address){
        addressService.updateAddressById(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(@PathVariable Long id){
        addressService.deleteAddressById(id);
    }
}

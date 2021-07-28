package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.dto.AddressRequest;
import com.muates.springbootbookstore.service.AddressService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getAddressById(id));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
        return ResponseEntity.ok(addressService.saveAddress(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressById(@PathVariable Long id, @Valid @RequestBody Address address) {
        addressService.updateAddressById(id, address);
        return ResponseEntity.ok("Address is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok("Address is deleted");
    }

    private Address convertToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .country(addressRequest.getCountry())
                .city(addressRequest.getCity())
                .street(addressRequest.getStreet())
                .postCode(addressRequest.getPostCode())
                .build();
    }
}

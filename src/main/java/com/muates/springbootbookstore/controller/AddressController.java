package com.muates.springbootbookstore.controller;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.dto.request.AddressRequest;
import com.muates.springbootbookstore.dto.response.AddressResponse;
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
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id) {
        AddressResponse addressResponse = convertToAddressResponse(addressService.getAddressById(id));
        return ResponseEntity.ok(addressResponse);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<AddressResponse> saveAddress(@Valid @RequestBody AddressRequest addressRequest) {
        Address savedAddress = addressService.saveAddress(convertToAddress(addressRequest));
        return ResponseEntity.ok(convertToAddressResponse(savedAddress));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAddressById(@PathVariable Long id, @Valid @RequestBody AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
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
                .id(addressRequest.getId())
                .country(addressRequest.getCountry())
                .city(addressRequest.getCity())
                .street(addressRequest.getStreet())
                .postCode(addressRequest.getPostCode())
                .build();
    }

    private AddressResponse convertToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postCode(address.getPostCode())
                .build();
    }
}

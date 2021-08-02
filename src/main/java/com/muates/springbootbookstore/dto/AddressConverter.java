package com.muates.springbootbookstore.dto;

import com.muates.springbootbookstore.domain.Address;
import com.muates.springbootbookstore.dto.request.AddressRequest;
import com.muates.springbootbookstore.dto.response.AddressResponse;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static Address convertToAddress(AddressRequest addressRequest) {
        return Address.builder()
                .id(addressRequest.getId())
                .country(addressRequest.getCountry())
                .city(addressRequest.getCity())
                .street(addressRequest.getStreet())
                .postCode(addressRequest.getPostCode())
                .build();
    }

    public static AddressResponse convertToAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .country(address.getCountry())
                .city(address.getCity())
                .street(address.getStreet())
                .postCode(address.getPostCode())
                .build();
    }

    public static List<AddressResponse> convertAllAddressesToAddressResponse(List<Address> addressList) {
        return addressList.stream().map(AddressConverter::convertToAddressResponse).collect(Collectors.toList());
    }

}

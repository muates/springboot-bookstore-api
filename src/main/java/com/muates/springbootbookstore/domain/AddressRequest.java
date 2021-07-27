package com.muates.springbootbookstore.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressRequest {
    private int id;

    @NotNull
    private Country country;

    @NotNull
    private City city;

    @NotBlank
    private String street;

    @NotBlank
    private String postCode;

    public AddressRequest() {
    }

    public AddressRequest(int id, Country country, City city, String street, String postCode) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

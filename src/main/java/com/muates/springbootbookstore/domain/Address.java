package com.muates.springbootbookstore.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String postCode;


    public Address() {
    }

    public Address(int id, String country, String city, String street, String postCode) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(country, address.country) && Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(postCode, address.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, postCode);
    }
}

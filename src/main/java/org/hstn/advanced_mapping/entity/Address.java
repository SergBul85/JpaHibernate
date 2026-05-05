package org.hstn.advanced_mapping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    @Column(name = "country")
    String country;
    @Column(name = "city")
    String city;
    @Column(name = "street")
    String street;
    @Column(name = "house")
    int house;

    public Address() {
    }

    public Address(String country, String city, String street, int house) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by Julian.Chatterton on 4/24/2017.
 */

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AddressId")
    private Integer id;

    @Version
    private Integer version;

    private String streetAddress;
    private Integer zip;
    private String state;
    private String addressType;

    public Address() {

    }

    public Address(String streetAddress, Integer zip, String state, String addressType) {
        this.streetAddress = streetAddress;
        this.zip = zip;
        this.state = state;
        this.addressType = addressType;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
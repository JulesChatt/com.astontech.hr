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

    public Address() {

    }





}
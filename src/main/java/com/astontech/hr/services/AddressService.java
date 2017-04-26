package com.astontech.hr.services;

import com.astontech.hr.domain.Address;

/**
 * Created by Julian.Chatterton on 4/25/2017.
 */
public interface AddressService {

    Iterable<Address> listAllAddresses();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    Iterable<Address> saveAddressList(Iterable<Address> addressIterable);

    void deleteAddress(Integer id);

}

package com.astontech.hr.repositories;

import com.astontech.hr.domain.Address;
import org.springframework.data.repository.CrudRepository;import java.lang.Integer;

/**
 * Created by Julian.Chatterton on 4/25/2017.
 */
public interface AddressRepository extends CrudRepository<Address, Integer> {

}

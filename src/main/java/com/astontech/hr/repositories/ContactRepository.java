package com.astontech.hr.repositories;

import com.astontech.hr.domain.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Julian.Chatterton on 4/25/2017.
 */
public interface ContactRepository extends CrudRepository<Contact, Integer> {

}

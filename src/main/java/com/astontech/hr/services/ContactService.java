package com.astontech.hr.services;

import com.astontech.hr.domain.Contact;

/**
 * Created by Julian.Chatterton on 4/24/2017.
 */
public interface ContactService {

    Iterable<Contact> listAllContacts();

    Contact getContactById(Integer id);

    Contact saveContact(Contact contact);

    Iterable<Contact> saveContactList(Iterable<Contact> contactIterable);

    void deleteContact(Integer id);


}

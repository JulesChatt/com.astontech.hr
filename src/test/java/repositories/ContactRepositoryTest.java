package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Julian.Chatterton on 4/25/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testContactSave() {
        Contact contact = new Contact();
        contact.setFirstName("Test");
        contact.setLastName("Contact");
        contact.setCompany("TestCompany");
        contact.setPhoneNumber("Test phone");

        assertNull(contact.getId());
        contactRepository.save(contact);
        assertNotNull(contact.getId());

        //fetch test
        Contact fetchedContact = contactRepository.findOne(contact.getId());
        assertNotNull(fetchedContact);
        assertEquals(contact.getId(), fetchedContact.getId());

        //update
        fetchedContact.setFirstName("TestJulian");
        contactRepository.save(fetchedContact);

        Contact fetchUpdatedContact = contactRepository.findOne(fetchedContact.getId());
        assertEquals("TestJulian", fetchUpdatedContact.getFirstName());

    }

}

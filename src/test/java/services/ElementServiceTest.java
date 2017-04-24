package services;

import com.astontech.hr.Application;
import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by Julian.Chatterton on 3/24/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;

    @Test
    public void elementServiceSaveTest() {

        Element element = new Element("ServiceTest");

        //save element, verify it has an ID after the save
        assertNull(element.getId());
        elementService.saveElement(element);
        assertNotNull(element.getId());


        //test fetching
        Element fetchElement = elementService.getElementById(element.getId());
        assertNotNull(fetchElement);
        assertEquals(element.getId(), fetchElement.getId());


        //update test
        fetchElement.setElementName("Email");
        elementService.saveElement(fetchElement);

        Element updatedElement = elementService.getElementById(fetchElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");



    }
}

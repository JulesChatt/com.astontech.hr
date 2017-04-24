package services;

import com.astontech.hr.Application;
import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
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
public class ElementTypeServiceTest {


    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void elementTypeServiceSaveTest() {

        ElementType elementType = new ElementType("ServiceTest");

        //save elementType, verify it has an ID after the save
        assertNull(elementType.getId());
        elementTypeService.saveElementType(elementType);
        assertNotNull(elementType.getId());

        //test fetching
        ElementType fetchElement = elementTypeService.getElementTypeById(elementType.getId());
        assertNotNull(fetchElement);
        assertEquals(elementType.getId(), fetchElement.getId());

        //update test
        fetchElement.setElementTypeName("Stuff");
        elementTypeService.saveElementType(fetchElement);

        ElementType updatedElement = elementTypeService.getElementTypeById(fetchElement.getId());
        assertEquals(updatedElement.getElementTypeName(), "Stuff");


    }
}

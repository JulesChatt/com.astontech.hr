package repositories;

import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


/**
 * Created by Julian.Chatterton on 3/24/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration
public class ElementTypeRepositoryTest {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Test
    public void testSaveElementType() {
        //setup elementType
        ElementType elementType = new ElementType();
        elementType.setElementTypeName("Thing");

        //save elementType, verify it has an ID after the save
        assertNull(elementType.getId());
        elementTypeRepository.save(elementType);
        assertNotNull(elementType.getId());

        //test fetching
        ElementType fetchElement = elementTypeRepository.findOne(elementType.getId());
        assertNotNull(fetchElement);
        assertEquals(elementType.getId(), fetchElement.getId());

        //update test
        fetchElement.setElementTypeName("Stuff");
        elementTypeRepository.save(fetchElement);

        ElementType updatedElement = elementTypeRepository.findOne(fetchElement.getId());
        assertEquals(updatedElement.getElementTypeName(), "Stuff");
    }


}

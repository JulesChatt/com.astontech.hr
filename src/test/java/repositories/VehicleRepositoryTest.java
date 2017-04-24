package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testSaveVehicle() {
        //setup vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setVin("testVehicle");

        //save vehicle and verify it has an ID
        assertNull(vehicle.getVehicleId());
        vehicleRepository.save(vehicle);
        assertNotNull(vehicle.getVehicleId());

        //test fetching
        Vehicle fetchVehicle = vehicleRepository.findOne(vehicle.getVehicleId());
        assertNotNull(fetchVehicle);
        assertEquals(vehicle.getVehicleId(), fetchVehicle.getVehicleId());


        //update test
        fetchVehicle.setVin("VinNumber");
        vehicleRepository.save(fetchVehicle);

        Vehicle updatedElement = vehicleRepository.findOne(fetchVehicle.getVehicleId());
        assertEquals(updatedElement.getVin(), "VinNumber");

    }
}

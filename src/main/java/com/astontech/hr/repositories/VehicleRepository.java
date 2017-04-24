package com.astontech.hr.repositories;

import com.astontech.hr.domain.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    //will auto generate the required code from the structure of the method name

    Vehicle findByVin(String vin);

   Vehicle findByVehicleId(Integer vehicleId);

    List<Vehicle> findAllByYear(String year);

    @Query(value = "SELECT VEHICLE_MODEL_VEHICLEMODELID FROM VEHICLE_MODEL_VEHICLE_LIST " +
            "where vehicle_list_vehicleid = :vehicleId"
            , nativeQuery = true
    )
    Integer findVehicleModelIdByVehicleId(@Param("vehicleId") Integer vehicleId);
}

package com.astontech.hr.services;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */
public interface VehicleService {




    Iterable<Vehicle> listAllVehicles();

    Vehicle getVehicleById(Integer id);

    Vehicle saveVehicle(Vehicle vehicle);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    void deleteVehicle(Integer id);

    //custom repo methods
    Vehicle findByVin(String vin);

    List<Vehicle> findAllByYear(String Year);

    VehicleModel findVehicleModelIdByVehicleId(Integer vehicleId);


}

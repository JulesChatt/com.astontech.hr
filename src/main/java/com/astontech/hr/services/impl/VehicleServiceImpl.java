package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Service
public class VehicleServiceImpl implements VehicleService {



    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public VehicleModel findVehicleModelIdByVehicleId(Integer vehicleId) {
        return vehicleModelRepository.findOne(vehicleRepository.findVehicleModelIdByVehicleId(vehicleId));
    }

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {




        return vehicleRepository.save(vehicle);
    }

    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable) {
        return vehicleRepository.save(vehicleIterable);
    }

    @Override
    public void deleteVehicle(Integer id) {

        // retrieve model of vehicle
        VehicleModel vehicleModel = findVehicleModelIdByVehicleId(id);

        // iterate thru model's vehicle list
        for (Iterator<Vehicle> iterator = vehicleModel.getVehicleList().iterator(); iterator.hasNext(); ) {
            Vehicle vehicle = iterator.next();
            if (vehicle.getVehicleId() == id) {
                // remove vehicle from model list
                iterator.remove();
            }
        }

        // save model
        vehicleModelRepository.save(vehicleModel);

        // delete vehicle
        vehicleRepository.delete(id);

    }

    @Override
    public Vehicle findByVin(String vin) {
        return vehicleRepository.findByVin(vin);
    }

    @Override
    public List<Vehicle> findAllByYear(String year) {
        return vehicleRepository.findAllByYear(year);
    }

}

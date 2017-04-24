package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Service
public class VehicleModelServiceImpl implements VehicleModelService {



    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;



    @Override
    public Iterable<VehicleModel> listAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public VehicleModel getVehicleModelName(VehicleModel vehicleModelName) {
        return vehicleModelRepository.save(vehicleModelName);
    }

    @Override
    public List<VehicleModel> findVehicleModelsByVehicleMakeId(Integer makeId) {
        return vehicleModelRepository.findVehicleModelsByVehicleMakeId(makeId);
    }

    @Override
    public VehicleMake findVehicleMakeIdByVehicleModelId(Integer vehicleModelId) {
        return vehicleMakeRepository.findOne(vehicleModelRepository.findVehicleMakeIdByVehicleModelId(vehicleModelId));
    }
}



package com.astontech.hr.services;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */
public interface VehicleModelService {

    Iterable<VehicleModel> listAllVehicleModels();

    VehicleModel getVehicleModelById(Integer id);

    VehicleModel getVehicleModelName(VehicleModel vehicleModelName);

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    List<VehicleModel> findVehicleModelsByVehicleMakeId(Integer makeId);



    VehicleMake findVehicleMakeIdByVehicleModelId(Integer vehicleModelId);



}

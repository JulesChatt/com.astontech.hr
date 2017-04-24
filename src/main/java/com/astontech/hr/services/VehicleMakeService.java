package com.astontech.hr.services;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;

import java.util.List;

/**
 * Created by Julian.Chatterton on 4/3/2017.
 */
public interface VehicleMakeService {

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    Iterable<VehicleMake> listAllVehicleMakes();

    VehicleMake getVehicleMakeById(Integer id);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);




}

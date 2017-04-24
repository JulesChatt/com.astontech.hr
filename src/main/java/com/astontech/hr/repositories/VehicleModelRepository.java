package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */
public interface VehicleModelRepository extends CrudRepository<VehicleModel, Integer> {

    VehicleModel findByVehicleModelName(String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelName(String vehicleModelName);

    List<VehicleModel> findAllByVehicleModelNameIgnoreCase(String vehicleModelName);


    @Query(value = "select * from  VEHICLE_MODEL B " +
            "inner join VEHICLE_MAKE_VEHICLE_MODEL_LIST A on B.VEHICLE_MODEL_ID = A.VEHICLE_MODEL_LIST_VEHICLEMODELID " +
            "where A.VEHICLE_MAKE_VEHICLEMAKEID = :vehicleMakeId"
            , nativeQuery = true)
    List<VehicleModel> findVehicleModelsByVehicleMakeId(@Param("vehicleMakeId") Integer vehicleMakeId);


    @Query(value = "SELECT VEHICLE_MAKE_VEHICLEMAKEID FROM VEHICLE_MAKE_VEHICLE_MODEL_LIST " +
            "where vehicle_model_list_vehicleModelId = :vehicleModelId"
            , nativeQuery = true
    )
    Integer findVehicleMakeIdByVehicleModelId(@Param("vehicleModelId") Integer vehicleModelId);
}

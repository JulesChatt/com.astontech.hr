package com.astontech.hr.domain.VO;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;

/**
 * Created by Julian.Chatterton on 4/3/2017.
 */
public class VehicleVO {
    private Vehicle vehicle;
    private VehicleModel vehicleModel;
    private VehicleMake vehicleMake;

//    private Integer vehicleId;
//    private String newVin;
//    private String newPlate;
//    private String newYear;
//    private String newColor;
//    private String newVehicleModel;
//    private String newVehicleMake;




    //region CONSTRUCTORS
    public VehicleVO() {

    }





    //endregion


    //region GETTERS AND SETTERS

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }




    //endregion

}

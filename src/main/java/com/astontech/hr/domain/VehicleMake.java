package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Entity
public class VehicleMake {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleMakeId")
    private Integer vehicleMakeId;

    @Version
    private Integer version;

    private String vehicleMakeName;

   @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<VehicleModel> vehicleModelList;


    //region CONSTRUCTORS
    public VehicleMake() {

    }

    public VehicleMake(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public VehicleMake(String vehicleMakeName, List<VehicleModel> vehicleModelList) {
        this.vehicleMakeName = vehicleMakeName;
        this.vehicleModelList = vehicleModelList;

    }
    //endregion

    //region GETTERS AND SETTERS

    public Integer getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(Integer vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleMakeName() {
        return vehicleMakeName;
    }

    public void setVehicleMakeName(String vehicleMakeName) {
        this.vehicleMakeName = vehicleMakeName;
    }

    public List<VehicleModel> getVehicleModelList() {
        return vehicleModelList;
    }

    public void setVehicleModelList(List<VehicleModel> vehicleModelList) {
        this.vehicleModelList = vehicleModelList;
    }


    //endregion



}
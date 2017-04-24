package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer vehicleModelId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Vehicle> vehicleList;

    @Version
    private Integer version;
    
    private String vehicleModelName;

    //region CONSTRUCTORS
    public VehicleModel() {

    }



    public VehicleModel(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleModel(String vehicleModelName, List<Vehicle> vehicleList) {
        this.vehicleModelName = vehicleModelName;
        this.vehicleList = vehicleList;
    }
    //

    //region GETTERS AND SETTERS

    public Integer getVehicleModelId() {
        return vehicleModelId;
    }

    public void setVehicleModelId(Integer vehicleModelId) {
        this.vehicleModelId = vehicleModelId;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }


    //endregion


}
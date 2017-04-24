package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer vehicleId;

    @Version
    private Integer version;

    private String year;
    private String licensePlate;
    private String vin;
    private String color;






    //region CONSTRUCTORS
    public Vehicle() {

    }

    public Vehicle( String vin, String licensePlate, String year, String color) {

        this.vin = vin;
        this.licensePlate = licensePlate;
        this.year = year;
        this.color = color;

    }






    //endregion

    //region GETTERS AND SETTERS


    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
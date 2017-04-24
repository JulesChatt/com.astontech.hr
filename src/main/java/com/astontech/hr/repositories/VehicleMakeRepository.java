package com.astontech.hr.repositories;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Julian.Chatterton on 4/3/2017.
 */
public interface VehicleMakeRepository extends CrudRepository<VehicleMake, Integer> {








}

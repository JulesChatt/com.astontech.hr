package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;

import com.astontech.hr.services.VehicleService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/30/2017.
 */

@Controller
public class VehicleController {

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleService vehicleService;

    private Logger log = Logger.getLogger(VehicleController.class);


    @RequestMapping(value = "/admin/vehicle/home", method = RequestMethod.GET)
    public String adminVehicleHomeGet(Model model) {

        return "admin/vehicle/vehicle_home";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleAddGet(Model model) {

        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());


        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehiclePost(VehicleVO vehicleVO, Model model) {

//        Adds new vehicle
        saveVehicleFromVehicleVO(vehicleVO);
        logVehicleVO(vehicleVO);

//        Populates make and model dropdowns
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());



        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String adminVehicleListGet(Model model) {

        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());


        return "admin/vehicle/vehicle_list";

    }

//    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.POST)
//    public String adminVehicleListPost(Model model) {
//
//        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
//
//
//        return "redirect:admin/vehicle/vehicle_list";
//
//    }


//    populates vehicle model dropdown based on make selection
    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public @ResponseBody
    List<VehicleModel> vehicleModelsByVehicleMake(@RequestParam(value = "selectedMake", required = true) Integer make)
    {
        return vehicleModelService.findVehicleModelsByVehicleMakeId(make);
    }



    @RequestMapping(value = "/admin/vehicle/delete/{vehicleId}", method = RequestMethod.GET)
    public String deleteVehicleGet(@PathVariable int vehicleId, Model model)
    {
        vehicleService.deleteVehicle(vehicleId);

        return "redirect:/admin/vehicle/list";

    }

    @RequestMapping(value = "/admin/vehicle/edit/{vehicleId}", method = RequestMethod.GET)
    public String adminVehicleEditGet(@PathVariable int vehicleId, Model model, VehicleVO vehicleVO) {

        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);

        VehicleModel vehicleModel = vehicleService.findVehicleModelIdByVehicleId(vehicleId);
        Integer modelId = vehicleModel.getVehicleModelId();

        VehicleMake vehicleMake = vehicleModelService.findVehicleMakeIdByVehicleModelId(modelId);

        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        model.addAttribute("vehicleList", vehicleService.getVehicleById(vehicleId));

        model.addAttribute("vehicle", vehicle);
        model.addAttribute("vehicleModelID", vehicleModel);
        model.addAttribute("vehicleMakeID", vehicleMake);


        return "/admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleEditPost(@ModelAttribute("vehicleVO") VehicleVO vehicleVO, Model model)
    {
//         vehicleVO.getVehicle().setVehicleId(vehicleId);
        Vehicle updatedVehicle =  vehicleVO.getVehicle();

        updatedVehicle.setVehicleId(vehicleVO.getVehicle().getVehicleId());

        vehicleService.saveVehicle(updatedVehicle);


        return "redirect:/admin/vehicle/list";
    }





    //region HELPER METHODS
    private void logVehicleVO(VehicleVO vehicleVO) {
        log.info("New Vehicle Vin: " + vehicleVO.getVehicle().getVin());
        log.info("New Vehicle Plate: " + vehicleVO.getVehicle().getLicensePlate());
        log.info("New Vehicle Year: " + vehicleVO.getVehicle().getYear());
        log.info("New Vehicle Color: " + vehicleVO.getVehicle().getColor());
        log.info("New Vehicle Model: " + vehicleVO.getVehicleModel().getVehicleModelName());

    }

    private void saveVehicleFromVehicleVO(VehicleVO vehicleVO) {


        VehicleModel retrievedVehicleModel = vehicleModelService.getVehicleModelById(vehicleVO.getVehicleModel().getVehicleModelId());

        Vehicle newVehicle = vehicleVO.getVehicle();

        //add new vehicle
        if (retrievedVehicleModel.getVehicleList() == null)
        {
            List<Vehicle> vehicleList = new ArrayList<Vehicle>();
            vehicleList.add(newVehicle);
            retrievedVehicleModel.setVehicleList(vehicleList);
        }
        else
        {
            retrievedVehicleModel.getVehicleList().add(newVehicle);
        }

        // save model

        vehicleModelService.saveVehicleModel(retrievedVehicleModel);


    }
    //endregion

}

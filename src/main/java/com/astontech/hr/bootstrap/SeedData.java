package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian.Chatterton on 3/27/2017.
 */

@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ContactService contactService;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //generateElementAndElementTypes();
        //generateVehicle();
        //generateEmployee();


    }

    private void generateElementAndElementTypes() {

        ElementType laptopType = new ElementType("Laptop");

        List<Element> elementLaptopList = new ArrayList<>();
        elementLaptopList.add(new Element("Acer"));
        elementLaptopList.add(new Element("Dell"));
        elementLaptopList.add(new Element("Samsung"));
        elementLaptopList.add(new Element("Apple"));
        elementLaptopList.add(new Element("Asus"));

        laptopType.setElementList(elementLaptopList);

        elementTypeService.saveElementType(laptopType);

        ElementType cellPhoneType = new ElementType("Cell Phone");

        List<Element> elementCellPhoneList = new ArrayList<>();
        elementCellPhoneList.add(new Element("iPhone"));
        elementCellPhoneList.add(new Element("Galaxy"));
        elementCellPhoneList.add(new Element("Black Berry"));
        elementCellPhoneList.add(new Element("Pixel"));


        cellPhoneType.setElementList(elementCellPhoneList);

        elementTypeService.saveElementType(cellPhoneType);

    }





    private void generateVehicle() {


        List<Vehicle> elantraList = new ArrayList<Vehicle>();
        elantraList.add(new Vehicle("elantraVin1", "123ABC", "2000", "Blue"));
        elantraList.add(new Vehicle("elantraVin2", "444VVV", "2001", "Green"));
        elantraList.add(new Vehicle("elantraVin3", "456HHH", "2002", "Silver"));
        elantraList.add(new Vehicle("elantraVin4", "555HTE", "2011", "Red"));

        List<Vehicle> sonataList = new ArrayList<Vehicle>();
        sonataList.add(new Vehicle("sonataVin1", "123ABC", "2000", "Blue"));
        sonataList.add(new Vehicle("sonataVin2", "444VVV", "2001", "Green"));
        sonataList.add(new Vehicle("sonataVin3", "456HHH", "2002", "Silver"));
        sonataList.add(new Vehicle("sonataVin4", "555HTE", "2011", "Red"));

        List<Vehicle> s10List = new ArrayList<Vehicle>();
        s10List.add(new Vehicle("s10Vin1", "123ABC", "2000", "Blue"));
        s10List.add(new Vehicle("s10Vin2", "444VVV", "2001", "Green"));
        s10List.add(new Vehicle("s10Vin3", "456HHH", "2002", "Silver"));
        s10List.add(new Vehicle("s10Vin4", "555HTE", "2011", "Red"));

        List<Vehicle> corvetteList = new ArrayList<Vehicle>();
        corvetteList.add(new Vehicle("corvetteVin1", "123ABC", "2000", "Blue"));
        corvetteList.add(new Vehicle("corvetteVin2", "444VVV", "2001", "Green"));
        corvetteList.add(new Vehicle("corvetteVin3", "456HHH", "2002", "Silver"));
        corvetteList.add(new Vehicle("corvetteVin4", "555HTE", "2011", "Red"));

        List<Vehicle> silveradoList = new ArrayList<Vehicle>();
        silveradoList.add(new Vehicle("silvaradoVin1", "123ABC", "2000", "Blue"));
        silveradoList.add(new Vehicle("silvaradoVin2", "444VVV", "2001", "Green"));
        silveradoList.add(new Vehicle("silvaradoVin3", "456HHH", "2002", "Silver"));
        silveradoList.add(new Vehicle("silvaradoVin4", "555HTE", "2011", "Red"));

        List<Vehicle> impalaList = new ArrayList<Vehicle>();
        impalaList.add(new Vehicle("impalaVin1", "123ABC", "2000", "Blue"));
        impalaList.add(new Vehicle("impalaVin2", "444VVV", "2001", "Green"));
        impalaList.add(new Vehicle("impalaVin3", "456HHH", "2002", "Silver"));
        impalaList.add(new Vehicle("impalaVin4", "555HTE", "2011", "Red"));

        List<Vehicle> voltList = new ArrayList<Vehicle>();
        voltList.add(new Vehicle("voltVin1", "123ABC", "2000", "Blue"));
        voltList.add(new Vehicle("voltVin2", "444VVV", "2001", "Green"));
        voltList.add(new Vehicle("voltVin3", "456HHH", "2002", "Silver"));
        voltList.add(new Vehicle("voltVin4", "555HTE", "2011", "Red"));

        List<VehicleModel> hyundaiModels = new ArrayList<VehicleModel>();
        hyundaiModels.add(new VehicleModel("Elantra", elantraList));
        hyundaiModels.add(new VehicleModel("Sonata", sonataList));


        List<VehicleModel> chevyModels = new ArrayList<>();
        chevyModels.add(new VehicleModel("S10", s10List));
        chevyModels.add(new VehicleModel("Corvette", corvetteList));
        chevyModels.add(new VehicleModel("Silverado", silveradoList));
        chevyModels.add(new VehicleModel("Impala", impalaList));
        chevyModels.add(new VehicleModel("Volt", voltList));

        List<VehicleMake> vehicleMakes = new ArrayList<>();
        vehicleMakes.add(new VehicleMake("Hyundai", hyundaiModels));
        vehicleMakes.add(new VehicleMake("Chevy", chevyModels));

        vehicleMakeService.saveVehicleMakeList(vehicleMakes);

    }

    private void generateEmployee() {

        Employee employee1 = new Employee();
        employee1.setFirstName("Julian");
        employee1.setLastName("Chatterton");
        employee1.setBackground("Java Guru");

        employeeService.saveEmployee(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Aaron");
        employee2.setLastName("Thiele");
        employee2.setBackground("Servlet Master");

        employeeService.saveEmployee(employee2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Adam");
        employee3.setLastName("Mielke");
        employee3.setBackground("Java Developer");

        employeeService.saveEmployee(employee3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Ariana");
        employee4.setLastName("Raduechel");
        employee4.setBackground("UHG Java Developer");

        employeeService.saveEmployee(employee4);





    }

    private void generateContactAndAddress() {
        Contact contactAaron = new Contact("Aaron", "Theile", "Solar City", "612-555-9999");

        List<Address> addressListAaron = new ArrayList<Address>();
        addressListAaron.add(new Address("5555 Main St.", 55555 , "CA", "Home"));
        addressListAaron.add(new Address("5555 Parkdale Dr.", 66666, "MN", "Business"));
        addressListAaron.add(new Address("1247 1st Ave", 66666, "MN", "PO box"));

        contactAaron.setAddresses(addressListAaron);
        contactService.saveContact(contactAaron);


        Contact contactTom = new Contact("Tom", "B-Bow", "Hello Moon", "612-555-9999");

        List<Address> addressListTom = new ArrayList<>();
        addressListTom.add(new Address("5555 Virginia Cr.", 55555 , "CA", "Business"));


        contactTom.setAddresses(addressListTom);
        contactService.saveContact(contactTom);


    }



}

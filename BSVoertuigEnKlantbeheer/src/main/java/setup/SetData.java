package setup;

import entities.*;
import services.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 24-11-2016.
 */

@Singleton
@Startup
public class SetData implements Serializable {

    @EJB
    private ICarService carService;

    @EJB
    private ICustomerService customerService;

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMechanicService mechanicService;

    @EJB
    private IModelService modelService;

    @EJB
    private IMaintenanceTypeService maintenanceTypeService;

    @PostConstruct
    public void setData() {
        Mechanic h1 = Mechanic.builder().Name("Henk").build();
        h1 = mechanicService.add(h1);
        Mechanic h2 = Mechanic.builder().Name("Arie").build();
        h2 = mechanicService.add(h2);
        Mechanic h3 = Mechanic.builder().Name("Lotte").build();
        h3 = mechanicService.add(h3);

        MaintenanceType maintenanceType1 = MaintenanceType.builder().name("apk-keuring").build();
        maintenanceType1 = maintenanceTypeService.add(maintenanceType1);

        MaintenanceType maintenanceType2 = MaintenanceType.builder().name("grote beurt").build();
        maintenanceType2 = maintenanceTypeService.add(maintenanceType2);

        Brand b1 = Brand.builder().name("Opel").build();
        Brand b2 = Brand.builder().name("Volkswagen").build();
        Brand b3 = Brand.builder().name("Porsche").build();
        Brand b4 = Brand.builder().name("Saab").build();
        Brand b5 = Brand.builder().name("Peugeot").build();
        Brand b6 = Brand.builder().name("Fiat").build();
        Brand b7 = Brand.builder().name("Honda").build();
        Brand b8 = Brand.builder().name("DAF").build();
        Brand b9 = Brand.builder().name("Citroën").build();

        Model m1a = Model.builder().brand(b1).name("Adam").build();

        m1a = modelService.add(m1a);
        Model m1b = Model.builder().brand(b1).name("Astra").build();
        m1b = modelService.add(m1b);
        Model m1c = Model.builder().brand(b1).name("Monza").build();
        m1c = modelService.add(m1c);
        Model m1d = Model.builder().brand(b1).name("Olympia").build();
        m1d = modelService.add(m1d);
        Model m1e = Model.builder().brand(b1).name("Zafira").build();
        m1e = modelService.add(m1e);
//
//        Model m2a = Model.builder().brand(b2).name("Eos").build();
//        modelService.add(m2a);
//        Model m2b = Model.builder().brand(b2).name("Passat").build();
//        modelService.add(m2b);
//        Model m2c = Model.builder().brand(b2).name("K70").build();
//        modelService.add(m2c);
//        Model m2d = Model.builder().brand(b2).name("Kever").build();
//        modelService.add(m2d);
//        Model m2e = Model.builder().brand(b2).name("Passat CC").build();
//        modelService.add(m2e);
//        Model m2f = Model.builder().brand(b2).name("Polo").build();
//        modelService.add(m2f);
//        Model m2g = Model.builder().brand(b2).name("Tiguan").build();
//        modelService.add(m2g);
//        Model m2h = Model.builder().brand(b2).name("Jetta").build();
//        modelService.add(m2h);
//        Model m2i = Model.builder().brand(b2).name("Golf").build();
//        modelService.add(m2i);
//        Model m2j = Model.builder().brand(b2).name("Lupo").build();
//        modelService.add(m2j);
//
//        Model m3a = Model.builder().brand(b3).name("Boxter").build();
//        modelService.add(m3a);
//        Model m3b = Model.builder().brand(b3).name("Cayman").build();
//        modelService.add(m3b);
//        Model m3c = Model.builder().brand(b3).name("912").build();
//        modelService.add(m3c);
//        Model m3d = Model.builder().brand(b3).name("959").build();
//        modelService.add(m3d);
//
//        Model m4a = Model.builder().brand(b4).name("Saab 9-3").build();
//        modelService.add(m4a);
//        Model m4b = Model.builder().brand(b4).name("Saab 9000").build();
//        modelService.add(m4b);
//
//        Model m5a = Model.builder().brand(b5).name("108").build();
//        modelService.add(m5a);
//        Model m5b = Model.builder().brand(b5).name("Bipper").build();
//        modelService.add(m5b);
//        Model m5c = Model.builder().brand(b5).name("Partner").build();
//        modelService.add(m5c);
//        Model m5d = Model.builder().brand(b5).name("107").build();
//        modelService.add(m5d);
//        Model m5e = Model.builder().brand(b5).name("306").build();
//        modelService.add(m5e);
//
//        Model m6a = Model.builder().brand(b6).name("500").build();
//        modelService.add(m6a);
//        Model m6b = Model.builder().brand(b6).name("Punto").build();
//        modelService.add(m6b);
//        Model m6c = Model.builder().brand(b6).name("124").build();
//        modelService.add(m6c);
//        Model m6d = Model.builder().brand(b6).name("Panda").build();
//        modelService.add(m6d);
//        Model m6e = Model.builder().brand(b6).name("242").build();
//        modelService.add(m6e);
//
//        Model m7a = Model.builder().brand(b7).name("Accord").build();
//        modelService.add(m7a);
//        Model m7b = Model.builder().brand(b7).name("Insight").build();
//        modelService.add(m7b);
//        Model m7c = Model.builder().brand(b7).name("CR-V").build();
//        modelService.add(m7c);
//        Model m7d = Model.builder().brand(b7).name("Concerto").build();
//        modelService.add(m7d);
//        Model m7e = Model.builder().brand(b7).name("Civic").build();
//        modelService.add(m7e);
//        Model m7f = Model.builder().brand(b7).name("CV-Z").build();
//        modelService.add(m7f);
//
//        Model m8a = Model.builder().brand(b8).name("A10").build();
//        modelService.add(m8a);
//        Model m8b = Model.builder().brand(b8).name("G1300").build();
//        modelService.add(m8b);
//        Model m8c = Model.builder().brand(b8).name("Pony").build();
//        modelService.add(m8c);
//        Model m8d = Model.builder().brand(b8).name("XF").build();
//        modelService.add(m8d);
//        Model m8e = Model.builder().brand(b8).name("CF").build();
//        modelService.add(m8e);
//        Model m8f = Model.builder().brand(b8).name("95 XF").build();
//        modelService.add(m8f);
//        Model m8g = Model.builder().brand(b8).name("Kalmar").build();
//        modelService.add(m8g);
//
//        Model m9a = Model.builder().brand(b9).name("C-Zero").build();
//        modelService.add(m9a);
//        Model m9b = Model.builder().brand(b9).name("C3 Picasso").build();
//        modelService.add(m9b);
//        Model m9c = Model.builder().brand(b9).name("Nemo").build();
//        modelService.add(m9c);
//        Model m9d = Model.builder().brand(b9).name("Xantia").build();
//        modelService.add(m9d);
//        Model m9e = Model.builder().brand(b9).name("C6").build();
//        modelService.add(m9e);
//        Model m9f = Model.builder().brand(b9).name("Saxo").build();
//        modelService.add(m9f);
//
        Customer c1 = Customer.builder().name("Annabel Veldwijk").email("AnnabelVeldwijk@teleworm.nl").phonenumber("0634442982").btwnumber("683513").adress("Knolwei 2 6333 DB  Schimmert").build();
        c1 = customerService.addCustomer(c1);
        Customer c2 = Customer.builder().name("Mirjan Doevendans").email("MirjanDoevendans@rhyta.com").phonenumber("0647936708").adress("Amsteldijk 6 1078 RS  Amsterdam").build();
        c2 = customerService.addCustomer(c2);
        Customer c3 = Customer.builder().name("Rivkas Simonis").email("RivkasSimonis@teleworm.org").phonenumber("0666796182").btwnumber("5402840").adress("Paadje van Duizend Tree 80 3039 ME  Rotterdam").build();
        c3 = customerService.addCustomer(c3);
        Customer c4 = Customer.builder().name("Sam van der Loop").email("SamvanderLoop@armyspy.com").phonenumber("0670843080").adress("Mathilde Berdenis van Berlekomstraat 38 1103 DP  Amsterdam-Zuidoost").build();
        c4 = customerService.addCustomer(c4);
        Customer c5 = Customer.builder().name("Dilara Martha").email("DilaraMartha@jourrapide.com").phonenumber("0684566780").adress("Doctor Plesmanstraat 53 3331 KG  Zwijndrecht").build();
        c5 = customerService.addCustomer(c5);

        Car a1 = Car.builder().vehicleNumber("1G6DC5E52C0154792").licensePlate("G-546-GA").mileage(4953939).driverEmail("SenadvanGalen@jourrapide.com").driverName("Senad").driverPhoneNumber("0667043888").customer(c1).model(m1a).build();
        carService.addCar(a1);
        Car a2 = Car.builder().vehicleNumber("JH2HE07C76K308145").licensePlate("KE-90-PA").mileage(4254368).driverEmail("").driverName("").driverPhoneNumber("").customer(c1).model(m1a).build();
        a2 = carService.addCar(a2);
//        Car a3 = Car.builder().vehicleNumber("3C6JR6EG6FG570826").licensePlate("850-PLA").mileage(6965445).driverEmail("").driverName("").driverPhoneNumber("").customer(c4).build();
//        carService.addCar(a3);
//        Car a4 = Car.builder().vehicleNumber("1GTH6BEA5F1184515").licensePlate("26-01-LW").mileage(798403).driverEmail("TamaravanGaal@rhyta.com").driverName("Tamara").driverPhoneNumber("0664790103").customer(c3).build();
//        carService.addCar(a4);
//        Car a5 = Car.builder().vehicleNumber("1M8PDMRA6WP012046").licensePlate("139-POT").mileage(482574).driverEmail("JolandavanderTuin@jourrapide.com").driverName("Jolanda").driverPhoneNumber("0636833009").customer(c3).build();
//        carService.addCar(a5);
//        Car a6 = Car.builder().vehicleNumber("1J8GR48KX5C588036").licensePlate("93-KF-DR").mileage(8796887).driverEmail("").driverName("").driverPhoneNumber("").customer(c5).build();
//        carService.addCar(a6);

        Maintenance m1 = Maintenance.builder().startDateTime(LocalDateTime.of(2015,  7,  1, 13,  5)).mechanic(h1).car(a2).type(maintenanceType1).state(MaintenanceState.PRESENT).description("Remschoenen vervangen").build();
        m1 = maintenanceService.add(m1);

        Maintenance m2 = Maintenance.builder().startDateTime(LocalDateTime.of(2015,  8,  5, 10, 40)).car(a2).mechanic(h2).type(maintenanceType2).state(MaintenanceState.PRESENT).type(maintenanceType1).description("Linker zijruit vervangen").build();
        maintenanceService.add(m2);
//        Maintenance m3 = Maintenance.builder().startDateTime(LocalDateTime.of(2015, 12, 18, 16, 35)).car(a1).mechanic(h3).type(maintenanceType1).state(MaintenanceState.PAUSED).type(maintenanceType2).description("Accu vervangen").build();
//        maintenanceService.add(m3);
//        Maintenance m4 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12,  5, 12, 10)).car(a5).mechanic(h3).type(maintenanceType2).state(MaintenanceState.PRESENT).type(maintenanceType2).description("Koplampen opnieuw afstellen").build();
//        maintenanceService.add(m4);
    }
}
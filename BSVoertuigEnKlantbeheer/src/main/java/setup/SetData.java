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

        MaintenanceType maintenanceType1 = MaintenanceType.builder().name("apk-keuring").sample(true).build();
        maintenanceType1 = maintenanceTypeService.add(maintenanceType1);

        MaintenanceType maintenanceType2 = MaintenanceType.builder().name("grote beurt").sample(false).build();
        maintenanceType2 = maintenanceTypeService.add(maintenanceType2);

        MaintenanceType maintenanceType3 = MaintenanceType.builder().name("banden").sample(false).build();
        maintenanceType3 = maintenanceTypeService.add(maintenanceType2);

        Brand b1 = Brand.builder().name("Opel").build();
        Brand b2 = Brand.builder().name("Volkswagen").build();

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

        Model m2a = Model.builder().brand(b2).name("Eos").build();
        m2a = modelService.add(m2a);
        Model m2b = Model.builder().brand(b2).name("Passat").build();
        m2b = modelService.add(m2b);
        Model m2c = Model.builder().brand(b2).name("K70").build();
        m2c = modelService.add(m2c);
        Model m2d = Model.builder().brand(b2).name("Kever").build();
        m2d = modelService.add(m2d);
        Model m2e = Model.builder().brand(b2).name("Passat CC").build();
        m2e = modelService.add(m2e);
        Model m2f = Model.builder().brand(b2).name("Polo").build();
        m2f = modelService.add(m2f);
        Model m2g = Model.builder().brand(b2).name("Tiguan").build();
        m2g = modelService.add(m2g);
        Model m2h = Model.builder().brand(b2).name("Jetta").build();
        m2h = modelService.add(m2h);
        Model m2i = Model.builder().brand(b2).name("Golf").build();
        m2i = modelService.add(m2i);
        Model m2j = Model.builder().brand(b2).name("Lupo").build();
        m2j = modelService.add(m2j);

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
        a1 = carService.addCar(a1);
        Car a2 = Car.builder().vehicleNumber("JH2HE07C76K308145").licensePlate("KE-90-PA").mileage(4254368).driverEmail("").driverName("").driverPhoneNumber("").customer(c1).model(m1a).build();
        a2 = carService.addCar(a2);
        Car a3 = Car.builder().vehicleNumber("3C6JR6EG6FG570826").licensePlate("850-PLA").mileage(6965445).driverEmail("").driverName("").driverPhoneNumber("").customer(c4).model(m2j).build();
        a3 = carService.addCar(a3);
        Car a4 = Car.builder().vehicleNumber("1GTH6BEA5F1184515").licensePlate("26-01-LW").mileage(798403).driverEmail("TamaravanGaal@rhyta.com").driverName("Tamara").driverPhoneNumber("0664790103").model(m1a).customer(c3).build();
        a4 = carService.addCar(a4);
        Car a5 = Car.builder().vehicleNumber("1M8PDMRA6WP012046").licensePlate("139-POT").mileage(482574).driverEmail("JolandavanderTuin@jourrapide.com").driverName("Jolanda").driverPhoneNumber("0636833009").model(m2h).customer(c3).build();
        a5 = carService.addCar(a5);
        Car a6 = Car.builder().vehicleNumber("1J8GR48KX5C588036").licensePlate("93-KF-DR").mileage(8796887).driverEmail("").driverName("").driverPhoneNumber("").model(m2g).customer(c5).build();
        a6 = carService.addCar(a6);

        Maintenance m1 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 13, 5)).car(a2).mechanic(h1).type(maintenanceType1).state(MaintenanceState.INMAINTENANCE).description("Remschoenen vervangen").build();
        maintenanceService.add(m1);
        Maintenance m2 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 10, 40)).car(a2).mechanic(h2).type(maintenanceType2).state(MaintenanceState.PRESENT).description("Linker zijruit vervangen").build();
        maintenanceService.add(m2);
        Maintenance m3 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 16, 35)).car(a1).mechanic(h3).type(maintenanceType1).state(MaintenanceState.PLANNED).description("Accu vervangen").build();
        maintenanceService.add(m3);
        Maintenance m4 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 12, 10)).car(a5).mechanic(h3).type(maintenanceType2).state(MaintenanceState.PLANNED).description("Koplampen opnieuw afstellen").build();
        maintenanceService.add(m4);
        Maintenance m5 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 14, 20)).car(a4).mechanic(h2).type(maintenanceType3).state(MaintenanceState.PLANNED).description("Winterbanden aanbrengen").build();
        maintenanceService.add(m5);
        Maintenance m6 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 13, 13)).car(a3).mechanic(h1).type(maintenanceType3).state(MaintenanceState.PLANNED).description("lekkeband links").build();
        maintenanceService.add(m6);
        Maintenance m7 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 14, 30)).car(a6).mechanic(h3).type(maintenanceType1).state(MaintenanceState.PLANNED).description("-").build();
        maintenanceService.add(m7);
        Maintenance m8 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 15, 40)).car(a1).mechanic(h3).type(maintenanceType2).state(MaintenanceState.PLANNED).description("kapotte voorruit").build();
        maintenanceService.add(m8);
        Maintenance m9 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 16, 45)).car(a2).mechanic(h2).type(maintenanceType1).state(MaintenanceState.PAUSED).description("Wachten op onderdeel").build();
        maintenanceService.add(m9);
        Maintenance m10 = Maintenance.builder().startDateTime(LocalDateTime.of(2016, 12, 1, 16, 10)).car(a3).mechanic(h2).type(maintenanceType3).state(MaintenanceState.INMAINTENANCE).description("Airco is kapot").build();
        maintenanceService.add(m10);
    }
}
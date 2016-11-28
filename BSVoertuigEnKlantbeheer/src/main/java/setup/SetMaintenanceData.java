package setup;

import entities.*;
import services.ICarService;
import services.IMaintenanceService;
import services.IMechanicService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Sander on 22-11-2016.
 */
@Singleton
@Startup
public class SetMaintenanceData implements Serializable {
    @EJB
    private ICarService carService;

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMechanicService mechanicService;

    @PostConstruct
    public void setData() {
        Mechanic henk = Mechanic.builder().Name("henk").build();
        mechanicService.add(henk);

        Brand brand = Brand.builder().name("Seat").build();
        Model model = Model.builder().name("Altea").brand(brand).build();
        Car car = new Car();
        car.setVehicleNumber("11234");
        car.setDriverEmail("test@mail.com");
        car.setDriverName("test name");
        car.setDriverPhoneNumber("1234567897");
        car.setLicensePlate("license plate");
        car.setMileage(4200);
        car.setModel(model);
        carService.addCar(car);

        Maintenance maintenance = new Maintenance();
        maintenance.setStartDateTime(LocalDateTime.now());
        maintenance.setDescription("dit is de beschrijving");
        maintenance.setMechanic(henk);
        maintenance.setCar(car);
        maintenance.present();
        maintenance.setType(MaintenanceType.APKKEURING);
        maintenanceService.add(maintenance);

        Maintenance maintenance2 = new Maintenance();
        maintenance2.setStartDateTime(LocalDateTime.now());
        maintenance2.setDescription("dit is de beschrijving2");
        maintenance2.setMechanic(henk);
        maintenance2.setCar(car);
        maintenance2.present();
        maintenance.setType(MaintenanceType.APKKEURING);
        maintenanceService.add(maintenance2);
    }
}

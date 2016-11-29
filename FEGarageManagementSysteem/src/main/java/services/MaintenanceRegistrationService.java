package services;

import entities.*;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static entities.MaintenanceState.INMAINTENANCE;

/**
 * Created by paisanrietbroek on 28/11/2016.
 */

@Data
@Named("maintenanceRegistrationService")
@FlowScoped("maintenance_registration")
public class MaintenanceRegistrationService implements Serializable {

    @EJB
    private ICarService carService;

    @EJB
    private ICustomerService customerService;

    @EJB
    private IMaintenanceTypeService maintenanceTypeService;

    @EJB
    private IMechanicService mechanicService;

    @EJB
    private IMaintenanceService maintenanceService;

    private long id;
    private Car car;

    private String description;

    private MaintenanceType maintenanceType;

    private long mechanicID;

    private Mechanic mechanic;

    public MaintenanceRegistrationService() {
        this.car = new Car();
        this.maintenanceType = new MaintenanceType();
        this.mechanic = new Mechanic();
    }

    public void setCarData() {
        car = carService.getCar(car.getVehicleNumber());
    }
    public void setMechanicData() {
        mechanic = mechanicService.getMechanic(mechanicID);
    }

    public void setMaintenanceTypeData() {
        maintenanceType = maintenanceTypeService.getOneType(maintenanceType.getId());
    }

    public String goToConfirmPage() {
        return "confirm_maintenance";
    }

    public String goToMaintenanceRegisterPage() {
        return "maintenance_registration";
    }

    public String confirm() {

        // date is still missing, need a fix

        Maintenance maintenance = Maintenance.builder()
                .car(car)
                .description(description)
                .type(maintenanceType)
                .mechanic(mechanic)
                .state(INMAINTENANCE.PLANNED)
                .build();

        maintenanceService.add(maintenance);
        id = maintenance.getId();
        return "detail_maintenance";
    }
}

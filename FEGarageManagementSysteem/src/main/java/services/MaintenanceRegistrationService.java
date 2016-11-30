package services;

import entities.*;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static entities.MaintenanceState.INMAINTENANCE;

/**
 * Created by paisanrietbroek on 28/11/2016.
 */

@Data
@Named("maintenanceRegistrationService")
@SessionScoped()
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

    private long id = 999L;
    private Car car;

    private String description;

    private MaintenanceType maintenanceType;

    private long mechanicID;

    private Mechanic mechanic;

    private String date;
    private String time;
    private LocalDateTime localDateTime;

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

    public String confirm() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        localDateTime = LocalDateTime.parse(date + " " + time, formatter);

        Maintenance maintenance = Maintenance.builder()
                .car(car)
                .description(description)
                .type(maintenanceType)
                .mechanic(mechanic)
                .state(INMAINTENANCE.PLANNED)
                .startDateTime(localDateTime)
                .build();

        maintenance = maintenanceService.add(maintenance);
        id = maintenance.getId();
        return "details_maintenance.xhtml?faces-redirect=true&id=" + id;
    }
}

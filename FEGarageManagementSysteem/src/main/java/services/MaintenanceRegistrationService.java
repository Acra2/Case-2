package services;

import entities.Car;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by paisanrietbroek on 28/11/2016.
 */

@Data
@Named("maintenanceRegistrationService")
@FlowScoped("maintenance_registration")
public class MaintenanceRegistrationService implements Serializable {

    @EJB
    private ICarService carService;

    @EJB ICustomerService customerService;

    private Car car;

    private String description;

    public MaintenanceRegistrationService() {
        this.car = new Car();
    }

    public void setCarData() {
        car = carService.getCar(car.getVehicleNumber());
    }
}

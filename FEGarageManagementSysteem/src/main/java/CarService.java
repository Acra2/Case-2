import entities.Car;
import entities.Customer;
import entities.Maintenance;
import lombok.Getter;
import lombok.Setter;
import services.ICarService;
import services.ICustomerService;
import services.IMaintenanceService;
import services.IModelService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */

@Getter
@Setter
@Named("carService")
@SessionScoped
public class CarService implements Serializable {

    private Car car;

    private String updateKey;

    private Integer filterIndex = -9;
    @EJB
    private ICarService carService;

    @EJB
    private ICustomerService customerService;

    @EJB
    private IModelService modelService;

    @EJB
    private IMaintenanceService maintenanceService;

    public CarService() {
        car = new Car();
    }

    public void setSpecificCar(String key) {
        car = carService.getCar(key);
        if (car.getCustomer() == null) {
            car.setCustomer(new Customer());
        }
    }

    public void updateCar() {
        Customer customerByEmail = customerService.getCustomerByEmail(car.getCustomer().getEmail());
        if (customerByEmail != null) {
            car.setCustomer(customerByEmail);
        }
        carService.addCar(car);
    }


    public List getAllCars() {

        List<Car> allCars = carService.getAllCars();
        List<Car> tempCars = new ArrayList<>();
        switch (filterIndex) {
            case -1:
                for (Car car : allCars) {
                    if (hasMaintenance(car, LocalDateTime.now().minusDays(1)))
                        tempCars.add(car);
                }
                break;
            case 0:
                for (Car car : allCars) {
                    if (hasMaintenance(car, LocalDateTime.now()))
                        tempCars.add(car);
                }
                break;
            case 1:
                for (Car car : allCars) {
                    breakLoop:
                    if (car.getMaintenanceList().size() > 0)
                        for (Maintenance m : car.getMaintenanceList()) {
                            if (m.getStartDateTime().toLocalDate().isAfter(LocalDateTime.now().toLocalDate())) {
                                tempCars.add(car);
                            }
                        }

                }

                break;
            default:
                tempCars = allCars;
        }
        return tempCars;
    }

    private boolean hasMaintenance(Car car, LocalDateTime date) {

        if (car.getMaintenanceList().size() > 0)
            for (Maintenance m : car.getMaintenanceList()) {
                if (m.getStartDateTime().toLocalDate().isEqual(date.toLocalDate())) {
                    return true;
                }
            }
        return false;
    }

    public void addCar() {
        Customer customer = customerService.getCustomerByEmail(car.getCustomer().getEmail());
        if (customer == null) {
            customer = new Customer();
            customer.setEmail(car.getCustomer().getEmail());
        }
        car.setCustomer(customer);
        carService.addCar(car);
    }

    public void clearCar() {
        Customer customer = new Customer();
        this.car = new Car();
        car.setCustomer(customer);
    }

    public List getAllModels() {
        return modelService.getAllModels();
    }

    public List getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public List getMaintenceForCar() { return maintenanceService.getMaintenanceForCar(car); }
}

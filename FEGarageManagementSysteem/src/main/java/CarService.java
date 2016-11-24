import entities.Car;
import entities.Customer;
import lombok.Getter;
import lombok.Setter;
import services.ICarService;
import services.ICustomerService;
import services.IModelService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
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

    @EJB
    private ICarService carService;

    @EJB
    private ICustomerService customerService;

    @EJB
    private IModelService modelService;

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
        return carService.getAllCars();
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

}

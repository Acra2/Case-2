package services;

import entities.Car;
import entities.Customer;
import entities.Model;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by paisanrietbroek on 27/11/2016.
 */

@Data
@Named("carRegisterService")
@FlowScoped("car_registration")
public class CarRegistrationService implements Serializable {

    @EJB
    private ICustomerService customerService;

    @EJB
    private ICarService carService;

    @EJB
    private IModelService modelService;

    private Car car;
    private Long customerID;
    private Customer customer;
    private List<Customer> customerList;

    private Long modelID;

    public CarRegistrationService() {
        car = new Car();
        customer = new Customer();
    }

    @PostConstruct
    public void init() {
        customerList = customerService.getAllCustomers();
    }

    public List getCustomerList() {
        return customerService.getAllCustomers();
    }

    public String selectCustomer() {
        return "select_customer";
    }

    public String saveCar() {
        customer = customerService.getCustomer(customerID);
        car.setCustomer(customer);

        return "save_car";
    }

    public String done() {

        carService.addCar(car);

        return "/car";
    }

    public String goToCarRegistration() {
        return "car_registration";
    }

    public void setCustomer() {
        customer = customerService.getCustomer(customerID);
    }

    public void setModel() {
        Model model = modelService.getModel(modelID);
        car.setModel(model);
    }

}

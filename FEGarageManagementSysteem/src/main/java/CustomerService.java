/**
 * Created by Gebruiker on 23-11-2016.
 */

import entities.Car;
import entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.ICarService;
import services.ICustomerService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Named("customerService")
@SessionScoped
public class CustomerService implements Serializable {

    private Customer customer;
    private List carListOfSpecificCustomer;

    private CustomerService() {
        customer = new Customer();
    }

    @EJB
    private ICustomerService customerService;

    @EJB
    private ICarService carService;

    public List getData(){
        return customerService.getAllCustomers();
    }

    public void updateCustomer() {
        customerService.updateCustomer(customer);
    }

    public void addCustomer(){
        customerService.addCustomer(customer);
    }

    public void clearCustomer(){
        customer=new Customer();
    }

    public void setSpecificCustomer(Long id) {

        customer = customerService.getCustomer(id);
        if (customer == null){
            customer=new Customer();
        }
        setCarsForSpecificCustomer(id);
    }

    public void setCarsForSpecificCustomer(long id) {
        carListOfSpecificCustomer = carService.getCarsOfSpecificCustomer(id);
    }

}

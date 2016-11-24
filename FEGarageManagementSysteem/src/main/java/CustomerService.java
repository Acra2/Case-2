/**
 * Created by Gebruiker on 23-11-2016.
 */

import entities.Car;
import entities.Customer;
import entities.Maintenance;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    private Integer filterIndex = -9;
    @EJB
    private ICustomerService customerService;

    private List<Customer> allCustomers;
    @EJB
    private ICarService carService;
    public List getData() {

        allCustomers = customerService.getAllCustomers();
        List<Customer> tempCustomers = new ArrayList<>();
        switch (filterIndex) {
            case -1:
                for (Customer customer : allCustomers) {
                    if (hasMaintenance(customer, LocalDateTime.now().minusDays(1)))
                        tempCustomers.add(customer);
                }
                break;
            case 0:
                for (Customer customer : allCustomers) {
                    if (hasMaintenance(customer, LocalDateTime.now()))
                        tempCustomers.add(customer);
                }
                break;
            case 1:
                for (Customer customer : allCustomers) {
                    if (customer.getCars().size() > 0)
                        for (Car car : customer.getCars()) {
                            if (car.getMaintenanceList().size() > 0)
                                for (Maintenance m : car.getMaintenanceList()) {
                                    if (m.getStartDateTime().toLocalDate().isAfter(LocalDateTime.now().toLocalDate())) {
                                        tempCustomers.add(customer);
                                    }
                                }

                        }
                }
                break;
            default:
                tempCustomers = allCustomers;
        }
        return tempCustomers;
    }

    private boolean hasMaintenance(Customer customer, LocalDateTime date) {

        if (customer.getCars().size() > 0)
            for (Car car : customer.getCars()) {
                if (car.getMaintenanceList().size() > 0)
                    for (Maintenance m : car.getMaintenanceList()) {
                        if (m.getStartDateTime().toLocalDate().isEqual(LocalDateTime.now().toLocalDate())) {
                            return true;
                        }
                    }

            }

        return false;
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

/**
 * Created by Gebruiker on 23-11-2016.
 */

import entities.Car;
import entities.Customer;
import entities.Maintenance;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.ICustomerService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named("customer")
@SessionScoped
@Data
@NoArgsConstructor
public class CustomerService implements Serializable {

    private Customer temp = new Customer();

    private Integer filterIndex = -9;
    @EJB
    private ICustomerService customerService;

    private List<Customer> allCustomers;

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
                                    if (m.getStartDateTime().toLocalDate().isAfter(LocalDate.now())) {
                                        tempCustomers.add(temp);
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
                        if (m.getStartDateTime().toLocalDate().equals(LocalDateTime.now())) {
                            return true;
                        }
                    }

            }

        return false;
    }

    public void addCustomer() {
        customerService.addCustomer(temp);
    }

    public void updateCustomer() {
        customerService.addCustomer(temp);
    }

    public void clearCustomer() {
        temp = new Customer();
    }

    public void setSpecificCustomer(Long id) {

        temp = customerService.getCustomer(id);
        if (temp == null) {
            temp = new Customer();
        }
    }
}

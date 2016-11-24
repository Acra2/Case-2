/**
 * Created by Gebruiker on 23-11-2016.
 */

import entities.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;
import services.ICustomerService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("customer")
@SessionScoped
@Data
@NoArgsConstructor
public class CustomerService implements Serializable {

    private Customer temp = new Customer();

    @EJB
    private ICustomerService customerService;

    public List<Customer> getData(){
        return customerService.getAllCustomers();
    }

    public void addCustomer(){
        customerService.addCustomer(temp);
    }

    public void updateCustomer() {
        customerService.addCustomer(temp);
    }

    public void clearCustomer(){
        temp=new Customer();
    }

    public void setSpecificCustomer(Long id) {

        temp = customerService.getCustomer(id);
        if (temp == null){
            temp=new Customer();
        }
    }
}

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

    @EJB
    private ICustomerService customerService;

    public List<Customer> getData(){
        return customerService.getAllCustomers();
    }
}

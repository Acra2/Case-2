package services;

import entities.Customer;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Gebruiker on 22-11-2016.
 */
@Remote
public interface ICustomerService {

    Customer addCustomer(Customer customer);

    Customer getCustomer(Long CustomerNumber);

    List getAllCustomers();

    void updateCustomer(Customer customer);

    Customer getCustomerByEmail(String email);
}

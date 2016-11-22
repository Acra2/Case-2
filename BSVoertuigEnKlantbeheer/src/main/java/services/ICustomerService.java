package services;

import entities.Customer;

import java.util.List;

/**
 * Created by Gebruiker on 22-11-2016.
 */
public interface ICustomerService {

    void add(Customer customer);

    Customer get(Long CustomerNumber);

    List getAll();

    void update(Customer customer);
}

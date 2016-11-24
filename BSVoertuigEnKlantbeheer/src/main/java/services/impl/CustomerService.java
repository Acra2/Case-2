package services.impl;

import entities.Car;
import entities.Customer;
import services.ICarService;
import services.ICustomerService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Gebruiker on 22-11-2016.
 */

@Stateful
@Remote(ICustomerService.class)
public class CustomerService implements ICustomerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer getCustomer(Long customerNumber) {
        return em.find(Customer.class, customerNumber);
    }

    @Override
    public List getAllCustomers() {
        return em.createNamedQuery("getAllCustomers").getResultList();
    }

    @Override
    public void updateCustomer(Customer customer) {
        em.createNamedQuery("updateCustomer")
                .setParameter("name", customer.getName())
                .setParameter("email", customer.getEmail())
                .setParameter("adress", customer.getAdress())
                .setParameter("btwnumber", customer.getBtwnumber())
                .setParameter("phonenumber", customer.getPhonenumber())
                .setParameter("id", customer.getId())
                .executeUpdate();
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        try {
            Customer singleResult = em.createNamedQuery("getCustomerByEmail", Customer.class)
                    .setParameter("email", email).getSingleResult();

            return singleResult;
        } catch (Exception ex) {
            System.out.println("customer not found: " + ex.getMessage());
        }
        return null;
    }
}

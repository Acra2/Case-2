package services.impl;

import entities.Customer;
import javax.persistence.EntityManager;
import services.ICustomerService;
import java.util.List;

import interceptors.LogInterceptorBinding;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * Created by Gebruiker on 22-11-2016.
 */

@Stateless
@Remote(ICustomerService.class)
@LogInterceptorBinding
public class CustomerService implements ICustomerService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Customer addCustomer(Customer customer) {
        if (customer.getId() != null)
            em.merge(customer);
        else
            em.persist(customer);

        return customer;
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
            throw ex;
        }
    }
}

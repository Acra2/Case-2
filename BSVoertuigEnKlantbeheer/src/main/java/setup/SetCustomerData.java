package setup;

import entities.Car;
import entities.Customer;
import services.ICarService;
import services.ICustomerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;

/**
 * Created by Gebruiker on 23-11-2016.
 */
@Singleton
@Startup
public class SetCustomerData implements Serializable{

    @EJB
    private ICustomerService customerService;

    @PostConstruct
    public void setData() {
        Customer customer = new Customer();
        customer.setPhonenumber("0543658587");
        customer.setEmail("paj.jansen@jansen.nl");
        customer.setBtwnumber("56587987");
        customer.setAdress("Leerpark 100 3320 AR Dordrecht");
        customer.setName("Piet Jansen");

        customerService.add(customer);
    }
}

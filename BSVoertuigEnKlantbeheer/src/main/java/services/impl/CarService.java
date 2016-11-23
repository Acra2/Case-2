package services.impl;

import entities.Car;
import services.ICarService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paisanrietbroek on 22/11/2016.
 */

@Stateful
@Remote(ICarService.class)
public class CarService implements ICarService {

    @PersistenceContext
    private EntityManager em;

    public void add(Car car) {
        em.persist(car);
    }

    public Car get(String vehicleNumber) {
        return em.find(Car.class,vehicleNumber);
    }

    public List getAll() {
        return em.createNamedQuery("getAll").getResultList();
    }

    public void update(Car car) {
        em.createNamedQuery("update")
                .setParameter("mail", car.getDriverEmail())
                .setParameter("name", car.getDriverName())
                .setParameter("phonenumber", car.getDriverPhoneNumber())
                .setParameter("licenseplate", car.getLicensePlate())
                .setParameter("mileage", car.getMileage())
                .setParameter("customer", car.getCustomer())
                .executeUpdate();
    }
}

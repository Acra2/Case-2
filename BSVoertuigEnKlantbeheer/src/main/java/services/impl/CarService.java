package services.impl;

import entities.Car;
import entities.Customer;
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

    @Override
    public void addCar(Car car) {
        em.merge(car);
    }

    @Override
    public Car getCar(String vehicleNumber) {
        return em.find(Car.class, vehicleNumber);
    }

    @Override
    public List getAllCars() {
        return em.createNamedQuery("getAll").getResultList();
    }

    @Override
    public void updateCar(Car car) {
        em.createNamedQuery("update")
                .setParameter("mail", car.getDriverEmail())
                .setParameter("name", car.getDriverName())
                .setParameter("phonenumber", car.getDriverPhoneNumber())
                .setParameter("licenseplate", car.getLicensePlate())
                .setParameter("mileage", car.getMileage())
                .setParameter("vehicleNumber", car.getVehicleNumber())
                .executeUpdate();
    }

    @Override
    public List getCarsOfSpecificCustomer(long id) {
        Customer customer = em.find(Customer.class, id);
        return em.createNamedQuery("getCarsOfSpecificCustomer", Car.class).setParameter("customer", customer).getResultList();
    }
}

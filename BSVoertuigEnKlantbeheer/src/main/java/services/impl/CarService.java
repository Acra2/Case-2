package services.impl;

import entities.Car;
import entities.Customer;
import services.ICarService;
import javax.persistence.EntityManager;
import java.util.List;

import interceptors.LogInterceptorBinding;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;

/**
 * Created by paisanrietbroek on 22/11/2016.
 */

@Stateful
@Remote(ICarService.class)
@LogInterceptorBinding
public class CarService implements ICarService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Car addCar(Car car) {
        if (car.getId() != null) {
            em.merge(car);
        } else {
            em.persist(car);
        }
        return car;
    }

    @Override
    public Car getCar(String vehicleNumber) {
        return (Car) em.createNamedQuery("getOneCar").setParameter("vehicleNumber", vehicleNumber).getSingleResult();
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

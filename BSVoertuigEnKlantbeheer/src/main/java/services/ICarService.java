package services;

import entities.Car;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
@Remote
public interface ICarService {
    void addCar(Car car);

    Car getCar(String vehicleNumber);

    List getAllCars();

    void updateCar(Car car);

    List getCarsOfSpecificCustomer(long id);
}

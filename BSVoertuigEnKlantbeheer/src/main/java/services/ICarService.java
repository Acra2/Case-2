package services;

import entities.Car;

import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
public interface ICarService {
    void add(Car car);

    Car get(String vehicleNumber);

    List getAll();

    void update(Car car);
}

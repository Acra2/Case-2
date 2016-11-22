package interfaces;

import entities.Car;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by paisanrietbroek on 22/11/2016.
 */

@Remote
public interface CarInterface {
    public void add(Car car);
    public Car get(String vehicleNumber);
    public List<Car> getAll();
    public void update(Car car);
}

import entities.Car;
import lombok.Getter;
import lombok.Setter;
import services.ICarService;
import services.IModelService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Getter
@Setter
@Named("car")
@SessionScoped
public class CarService implements Serializable {

    private Car car;

    private String updateKey;

    @EJB
    private ICarService carService;

    public void setSpecificCar(String key) {
        car = carService.getCar(key);
        System.out.println(car.getDriverEmail());
    }

    @EJB
    private IModelService modelService;

    public void updateCar() {
        carService.updateCar(car);
    }

    public CarService() {
        this.car = new Car();
    }

    public List getAllCars() {
        return carService.getAllCars();
    }

    public void addCar() {
        carService.addCar(car);
    }

    public List getAllModels() {
        return modelService.getAllModels();
    }

    public void testmethod() {
        System.out.println("parameter method");
    }

}

package setup;

import entities.Car;
import services.ICarService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;

/**
 * Created by paisanrietbroek on 22/11/2016.
 */

@Singleton
@Startup
public class SetCarData implements Serializable{

    @EJB
    private ICarService carService;

    @PostConstruct
    public void setData() {
        Car car = new Car();
        car.setVehicleNumber("test number");
        car.setDriverEmail("test@mail.com");
        car.setDriverName("test name");
        car.setDriverPhoneNumber("1234567897");
        car.setLicensePlate("license plate");
        car.setMileage(4200);

        Car car1 = new Car();
        car1.setVehicleNumber("test2 number");
        car1.setDriverEmail("test@mail.com");
        car1.setDriverName("test name");
        car1.setDriverPhoneNumber("1234567897");
        car1.setLicensePlate("license plate");
        car1.setMileage(4200);

        Car car2 = new Car();
        car2.setVehicleNumber("test3 number");
        car2.setDriverEmail("test@mail.com");
        car2.setDriverName("test name");
        car2.setDriverPhoneNumber("1234567897");
        car2.setLicensePlate("license plate");
        car2.setMileage(4200);

        carService.addCar(car);
        carService.addCar(car1);
        carService.addCar(car2);
    }
}

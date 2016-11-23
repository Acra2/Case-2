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

        carService.add(car);
    }
}

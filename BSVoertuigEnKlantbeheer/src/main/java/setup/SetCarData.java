package setup;

import entities.Brand;
import entities.Car;
import entities.Customer;
import entities.Model;
import services.ICarService;
import services.ICustomerService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * Created by paisanrietbroek on 22/11/2016.
 */

@Singleton
@Startup
public class SetCarData implements Serializable{

    @EJB
    private ICarService carService;

    @EJB
    private ICustomerService customerService;

    @PostConstruct
    public void setData() {

        Car car = new Car();
        car.setVehicleNumber("11234");
        car.setDriverEmail("test@mail.com");
        car.setDriverName("test name");
        car.setDriverPhoneNumber("1234567897");
        car.setLicensePlate("license plate");
        car.setCustomer(Customer.builder().email("email").name("name").build());
        car.setMileage(4200);

        Car car1 = new Car();
        car1.setVehicleNumber("22345");
        car1.setDriverEmail("test@mail.com");
        car1.setDriverName("test name");
        car1.setDriverPhoneNumber("1234567897");
        car1.setLicensePlate("license plate");
        car1.setMileage(4200);

        Car car2 = new Car();
        car2.setVehicleNumber("33445");
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

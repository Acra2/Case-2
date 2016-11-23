package setup;

import entities.Brand;
import entities.Car;
import entities.Model;
import services.ICarService;
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

    @PostConstruct
    public void setData() {
        //Brand brand = Brand.builder().name("Seat").build();
        Model model = Model.builder().name("Altea").build();
        Car car = new Car();
        car.setVehicleNumber("test number");
        car.setDriverEmail("test@mail.com");
        car.setDriverName("test name");
        car.setDriverPhoneNumber("1234567897");
        car.setLicensePlate("license plate");
        car.setMileage(4200);
        car.setModel(model);

        carService.add(car);

//        Model model2 = Model.builder().name("Leon").build();
        Car car2 = Car.builder().vehicleNumber("test nember2").model(model).build();
        carService.add(car2);
//        System.out.println(carService.get("test number").getDriverEmail());
    }
}

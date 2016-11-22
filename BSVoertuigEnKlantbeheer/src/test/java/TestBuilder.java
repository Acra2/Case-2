import entities.Car;
import entities.Customer;
import entities.Maintenance;
import entities.MaintenanceState;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Currency;

/**
 * Created by Sander on 22-11-2016.
 */
public class TestBuilder {

    public  static Customer.CustomerBuilder customer(){
        return Customer.builder().name("Sander").adress("Leerpark 50").email("sander@gmail.com");
    }

    public static Car.CarBuilder car(){
        return Car.builder().customer(customer().build()).vehiclenumber("1234").licenseplate("50-16-AB");
    }

    public static Maintenance.MaintenanceBuilder maintenance(){
        return Maintenance.builder().car(car().build()).startDateTime(LocalDateTime.now()).state(MaintenanceState.PLANNED);
    }
}

import entities.*;

import java.time.LocalDateTime;

/**
 * Created by Sander on 22-11-2016.
 */
public class TestBuilder {

    public static MaintenanceType.MaintenanceTypeBuilder maintenanceType1() {
        return MaintenanceType.builder().name("apk-keuring").sample(true);
    }

    public static MaintenanceType.MaintenanceTypeBuilder maintenanceType2() {
        return MaintenanceType.builder().name("grote-beurt").sample(false);
    }

    public static Mechanic.MechanicBuilder mechanic1() {
        return Mechanic.builder().id(1L).Name("Machanic 1");
    }

    public static Mechanic.MechanicBuilder mechanic2() {
        return Mechanic.builder().id(2L).Name("Machanic 2");
    }

    public static Car.CarBuilder car1() {
        return Car.builder().vehicleNumber("1234").licensePlate("50-16-AB");
    }

    public static Car.CarBuilder car2() {
        return Car.builder().vehicleNumber("5678").licensePlate("55-80-CD");
    }

    public static Maintenance.MaintenanceBuilder maintenance1() {
        return Maintenance.builder()
                .car(car1().build())
                .mechanic(mechanic1().build())
                .startDateTime(LocalDateTime.now())
                .state(MaintenanceState.PRESENT);
    }

    public static Maintenance.MaintenanceBuilder maintenance2() {
        return Maintenance.builder()
                .car(car2().build())
                .mechanic(mechanic2().build())
                .startDateTime(LocalDateTime.now())
                .state(MaintenanceState.PRESENT);
    }
}

package services;

import entities.Car;
import entities.Maintenance;
import entities.Mechanic;
import sun.applet.Main;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */

@Remote
public interface IMaintenanceService {
    List<Maintenance> getAll();
    Maintenance getOne(Long id);
    void add(Maintenance maintenance);
    Maintenance getInMaintenanceForMechanic(Mechanic mechanic);

    List getMaintenanceForCar(Car car);
    List getCarsInMaintenance();
}

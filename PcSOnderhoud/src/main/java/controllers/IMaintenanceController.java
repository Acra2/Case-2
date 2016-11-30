package controllers;

import entities.Maintenance;
import entities.Mechanic;
import entities.StateException;

import javax.ejb.Remote;

/**
 * Created by Sander on 23-11-2016.
 */
@Remote
public interface IMaintenanceController {
    ;

    Maintenance getMaintenance(Long id);

    Maintenance changeMechanic(Maintenance maintenance, String id);

    boolean showButton(Maintenance maintenance, String state);

    void persistMaintenace(Maintenance maintenance);

    boolean actions(Maintenance maintenance);

    Maintenance checkInMaintenance(Mechanic mechanic);

    void present(Maintenance maintenance) throws StateException;

    void start(Maintenance maintenance) throws StateException;

    void pause(Maintenance maintenance) throws StateException;

    void finish(Maintenance maintenance) throws Exception;

    void readyForPickup(Maintenance maintenance) throws StateException;

    void pickup(Maintenance maintenance) throws StateException;
}

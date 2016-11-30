package controllers;

import entities.Maintenance;
import entities.Mechanic;
import entities.StateException;
import interceptors.LogInterceptorBinding;
import rdw.CdiProvider;
import services.IMaintenanceService;
import services.IMechanicService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Created by Sander on 23-11-2016.
 */
@Stateful
@Remote(IMaintenanceController.class)
@LogInterceptorBinding
public class MaintenanceController implements IMaintenanceController {

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMechanicService mechanicService;

    private CdiProvider provider = new CdiProvider();

    @Override
    public Maintenance getMaintenance(Long id) {
        return maintenanceService.getOne(id);
    }

    @Override
    public Maintenance changeMechanic(Maintenance maintenance, String id) {
        long l = Long.parseLong(id);
        Mechanic mechanic = mechanicService.getMechanic(l);
        if (mechanic != null) {
            maintenance.setMechanic(mechanic);
            maintenanceService.add(maintenance);
            return maintenance;
        } else
            return null;
    }

    @Override
    public boolean showButton(Maintenance maintenance, String state) {
        for (String operation : maintenance.getState().getOperations()) {
            if (operation.equalsIgnoreCase(state)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void persistMaintenace(Maintenance maintenance) {
        maintenanceService.add(maintenance);
    }

    @Override
    public boolean actions(Maintenance maintenance) {
        return maintenance.getState().getOperations().length > 0;
    }

    @Override
    public Maintenance checkInMaintenance(Mechanic mechanic) {
        Maintenance inMaintenanceForMechanic = maintenanceService.getInMaintenanceForMechanic(mechanic);
        return inMaintenanceForMechanic;
    }

    @Override
    public void present(Maintenance maintenance) throws StateException {
        maintenance.present();
        persistMaintenace(maintenance);
    }

    @Override
    public void start(Maintenance maintenance) throws StateException {
        maintenance.start();
        persistMaintenace(maintenance);
    }

    @Override
    public void pause(Maintenance maintenance) throws StateException {
        maintenance.pause();
        persistMaintenace(maintenance);
    }

    @Override
    public void finish(Maintenance maintenance) throws Exception {
        maintenance.finish();
        persistMaintenace(maintenance);
        if (maintenance.getType().getSample()) {
            try {
                Boolean steekproef = false;

                steekproef = provider.provide().steekproef(maintenance.getCar().getLicensePlate());

                if (steekproef) {
                    maintenance.needInspections();
                } else {
                    maintenance.readyForPickUp();
                }
                persistMaintenace(maintenance);
            } catch (Exception e) {
                throw e;
            }
        } else {
            maintenance.readyForPickUp();
            persistMaintenace(maintenance);
        }
    }

    @Override
    public void readyForPickup(Maintenance maintenance) throws StateException {
        maintenance.readyForPickUp();
        persistMaintenace(maintenance);
    }

    @Override
    public void pickup(Maintenance maintenance) throws StateException {
        maintenance.pickUp();
        persistMaintenace(maintenance);
    }

}

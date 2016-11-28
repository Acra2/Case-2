package controllers;

import entities.Maintenance;
import entities.MaintenanceType;
import entities.Mechanic;
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
public class MaintenanceController implements IMaintenanceController {

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMechanicService mechanicService;

    //@Inject
    //private RDWSteekproefWebService_PortType rdwSteekproefWebService_portType;

    @Override
    public Maintenance getMaintenance(Long id) {
        for(Maintenance m : maintenanceService.getAll()){
            System.out.println("Maintenances:" + m.getId());
        }
        return maintenanceService.getOne(id);
    }

    @Override
    public Maintenance changeMechanic(Maintenance maintenance, String id) {
        for(Mechanic m : mechanicService.getAllMechanics()){
            System.out.println("mechanics: "+m.getId());
        }
        Mechanic mechanic = mechanicService.getMechanic(Long.parseLong(id));
        if (mechanic != null) {
            maintenance.setMechanic(mechanic);
            maintenanceService.add(maintenance);
            return maintenance;
        }else
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
    public Maintenance checkInMaintenance(Mechanic mechanic ){
        Maintenance inMaintenanceForMechanic = maintenanceService.getInMaintenanceForMechanic(mechanic);
        return inMaintenanceForMechanic;
    }

    @Override
    public void finish(Maintenance maintenance) {
        maintenance.finish();
        persistMaintenace(maintenance);
        if (maintenance.getType().getName().toLowerCase().equals("apk-keuring")){
            try {
                Boolean steekproef = false;

                //TODO fix wsdl
                //steekproef = rdwSteekproefWebService_portType.steekproef(maintenance.getCar().getLicensePlate());

                if (steekproef) {
                    maintenance.needInspections();
                }else{
                    maintenance.readyForPickUp();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

}

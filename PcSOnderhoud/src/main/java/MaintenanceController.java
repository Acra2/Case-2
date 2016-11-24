import entities.Maintenance;
import entities.Mechanic;
import services.IMaintenanceService;
import services.IMechanicService;
import services.impl.MaintenanceService;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NamedQuery;
import java.util.Arrays;

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

}

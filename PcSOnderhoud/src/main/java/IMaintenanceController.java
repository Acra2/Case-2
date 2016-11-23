import entities.Maintenance;
import entities.Mechanic;

import javax.ejb.Remote;

/**
 * Created by Sander on 23-11-2016.
 */
@Remote
public interface IMaintenanceController {
    Maintenance getMaintenance(Long id);
    Maintenance changeMechanic(Maintenance maintenance, String id);
    boolean showButton(Maintenance maintenance, String state);
    void persistMaintenace(Maintenance maintenance);
    boolean actions(Maintenance maintenance);
}

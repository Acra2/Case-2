package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class PresentState extends AbstractState {
    public void startMaintenace(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.INMAINTENANCE);
    }
    public String[] getOperations(){
        return new String[]{"start"};
    }
    public String toString() {
        return "Aanwezig";
    }
}

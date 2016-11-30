package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class WaitForInspectionState extends AbstractState {
    public void readyForPickUp(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.READYFORPICKUP);
    }

    public String[] getOperations(){
        return new String[]{"readyforpickup"};
    }
    public String toString() {
        return "Wacht op keuring";
    }
}

package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class ReadyForPickUpState extends AbstractState {
    public void pickedUp(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.PICKEDUP);
    }

    public String[] getOperations() {
        return new String[]{"pickup"};
    }

    public String toString() {
        return "Klaar voor uitleveren";
    }
}

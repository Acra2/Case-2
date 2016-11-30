package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class InMaintenanceState extends AbstractState {
    public void pauseMaintenace(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.PAUSED);
    }

    public void finishMaintenace(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.READYFORSAMPLE);
    }

    public String[] getOperations() {
        return new String[]{"pause", "finish"};
    }

    public String toString() {
        return "In onderhoud";
    }
}

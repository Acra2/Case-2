package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class PlannedState extends AbstractState {

    public void present(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.PRESENT);
    }

    public String toString(){
        return "Gepland";
    }
}

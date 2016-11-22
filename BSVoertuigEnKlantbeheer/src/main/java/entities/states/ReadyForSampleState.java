package entities.states;

import entities.AbstractState;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;

/**
 * Created by Sander on 22-11-2016.
 */
public class ReadyForSampleState extends AbstractState {
    public void needInspections(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.WAITFORINSPECTION);
    }

    public void readyForPickUp(Maintenance maintenance) throws StateException {
        maintenance.setState(MaintenanceState.READYFORPICKUP);
    }
}

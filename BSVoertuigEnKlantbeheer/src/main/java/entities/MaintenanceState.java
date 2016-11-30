package entities;

import entities.states.*;

/**
 * Created by Sander on 21-11-2016.
 */
public enum MaintenanceState {

    PLANNED (new PlannedState()),
    PRESENT (new PresentState()),
    INMAINTENANCE (new InMaintenanceState()),
    PAUSED (new PausedState()),
    READYFORSAMPLE (new ReadyForSampleState()),
    READYFORPICKUP (new ReadyForPickUpState()),
    WAITFORINSPECTION (new WaitForInspectionState()),
    PICKEDUP(new PickedUpState());

    private final AbstractState state;

    MaintenanceState(AbstractState state){
        this.state = state;
    }

    public void present(Maintenance maintenance) throws StateException {
        state.present(maintenance);
    }

    public void startMaintenace(Maintenance maintenance) throws StateException {
        state.startMaintenace(maintenance);
    }

    public void pauseMaintenace(Maintenance maintenance) throws StateException {
        state.pauseMaintenace(maintenance);
    }

    public void finishMaintenace(Maintenance maintenance) throws StateException {
        state.finishMaintenace(maintenance);
    }

    public void needInspections(Maintenance maintenance) throws StateException {
        state.needInspections(maintenance);
    }

    public void readyForPickUp(Maintenance maintenance) throws StateException {
        state.readyForPickUp(maintenance);
    }

    public void pickedUp(Maintenance maintenance) throws StateException {
        state.pickedUp(maintenance);
    }
    public String[] getOperations(){
        return state.getOperations();
    }

    public String toString(){
        return state.toString();
    }

}

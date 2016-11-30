package entities;

/**
 * Created by Sander on 22-11-2016.
 */
public abstract class AbstractState {

    public void present(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void startMaintenace(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void pauseMaintenace(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void finishMaintenace(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void needInspections(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void readyForPickUp(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public void pickedUp(Maintenance maintenance) throws StateException {
        throw new StateException("Invalid state transition");
    }

    public String[] getOperations() {
        return new String[]{};
    }

    public String toString() {
        return "";
    }
}

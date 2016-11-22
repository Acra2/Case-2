package entities;

import entities.states.PausedState;

/**
 * Created by Sander on 21-11-2016.
 */
public enum MaintenanceState {

    PAUSED (new PausedState());

    private final AbstractState state;

    MaintenanceState(AbstractState state){
        this.state = state;
    }

}

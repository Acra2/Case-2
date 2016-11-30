package entities.states;

import entities.AbstractState;

/**
 * Created by Sander on 22-11-2016.
 */
public class PickedUpState extends AbstractState {
    public String[] getOperations() {
        return new String[]{};
    }

    public String toString() {
        return "Opgehaald";
    }
}

import entities.Maintenance;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sander on 23-11-2016.
 */
@Named("maintenance")
@SessionScoped
@NoArgsConstructor
@Data
public class MaintenanceService implements Serializable {

    @EJB
    private IMaintenanceController maintenanceController;

    private UIComponent btCheckMechanicCodeInput;
    private UIComponent btMaintenanceInput;

    private Maintenance mainte;

    private String maintenanceInput = "";
    private String mechanicInput = "";
    private String changeMechanicInput = "";

    public void setMaintenance() {
        Long maintenanceId = Long.parseLong(maintenanceInput);
        mainte = maintenanceController.getMaintenance(maintenanceId);
        if (mainte == null) {
            FacesMessage message = new FacesMessage("Onderhoudsopdracht niet gevonden");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(btMaintenanceInput.getClientId(context), message);
        }
    }

    public boolean showButton(String state) {
        return maintenanceController.showButton(mainte, state);
    }

    public boolean actions() {
        return maintenanceController.actions(mainte);
    }

    public boolean checkMechanic() {
        boolean b = mechanicInput.equals(mainte.getMechanic().getId().toString());
        if (!b) {
            FacesMessage message = new FacesMessage("Verkeerde monteurscode");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(btCheckMechanicCodeInput.getClientId(context), message);
        }
        return b;
    }

    public void changeMechanic() {
        mainte = maintenanceController.changeMechanic(mainte, changeMechanicInput);
        changeMechanicInput = "";
    }

    public void start() {
        if (checkMechanic()) {
            mainte.start();
            maintenanceController.persistMaintenace(mainte);
            clearView();
        }
    }

    public void pause() {
        if (checkMechanic()) {
            mainte.pause();
            maintenanceController.persistMaintenace(mainte);
            clearView();
        }
    }

    public void finish() {
        if (checkMechanic()) {
            mainte.finish();
            maintenanceController.persistMaintenace(mainte);
            clearView();
        }
    }

    public void clearView() {
        mainte = null;

        maintenanceInput = "";
        mechanicInput = "";
    }
}

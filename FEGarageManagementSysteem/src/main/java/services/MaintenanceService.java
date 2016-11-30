package services;

import controllers.IMaintenanceController;
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
    private UIComponent btChanceMechanicCodeInput;
    private UIComponent btMaintenanceInput;

    private Maintenance mainte;
    private Maintenance otherMaintenance;
    private String maintenanceInput = "";
    private String mechanicInput = "";
    private String changeMechanicInput = "";

    public void setMaintenance() {
        Long maintenanceId = Long.parseLong(maintenanceInput);
        mainte = maintenanceController.getMaintenance(maintenanceId);
        otherMaintenance = null;
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
            FacesMessage message = new FacesMessage("Monteurscode incorrect");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(btCheckMechanicCodeInput.getClientId(context), message);
        }
        return b;
    }

    public void changeMechanic() {
        Maintenance maintenance = maintenanceController.changeMechanic(mainte, changeMechanicInput);
        if (maintenance == null) {
            FacesMessage message = new FacesMessage("Monteurscode incorrect");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(btChanceMechanicCodeInput.getClientId(context), message);
        } else {
            mainte = maintenance;
            changeMechanicInput = "";
        }
    }

    public void start() throws Exception {
        if (checkMechanic()) {
            otherMaintenance = maintenanceController.checkInMaintenance(mainte.getMechanic());
            if (otherMaintenance == null) {
                maintenanceController.start(mainte);
                clearView();
            }
        }
    }

    public void pause() throws Exception {
        if (checkMechanic()) {
            maintenanceController.pause(mainte);
            clearView();
        }
    }

    public void finish() throws Exception {
        if (checkMechanic()) {
            maintenanceController.finish(mainte);
            clearView();
        }
    }

    public void pauseOtherMaintenace() throws Exception {
        otherMaintenance.pause();
        maintenanceController.persistMaintenace(otherMaintenance);
        start();
    }

    public void finishOtherMaintenace() throws Exception {
        maintenanceController.finish(mainte);
        start();
    }

    public void clearView() {
        mainte = null;

        maintenanceInput = "";
        mechanicInput = "";
    }
}

package services;

import controllers.IMaintenanceController;
import entities.Maintenance;
import entities.StateException;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sander on 29-11-2016.
 */
@Getter
@Setter
@Named("maintenanceDetailsService")
@SessionScoped
public class MaintenanceDetailsService implements Serializable {

    private Maintenance maintenance;

    private String maintenanceId;

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMaintenanceController maintenanceController;

    public void setMaintenance() {
        maintenance = maintenanceService.getOne(Long.parseLong(maintenanceId));
    }

    public boolean showButton(String state) {
        return maintenanceController.showButton(maintenance, state);
    }

    public void changeState(String state) throws Exception{
        switch (state.toLowerCase()){
            case "present":
                maintenanceController.present(maintenance);
                break;
            case "start":
                maintenanceController.start(maintenance);
                break;
            case "pause":
                maintenanceController.pause(maintenance);
                break;
            case "finish":
                maintenanceController.finish(maintenance);
                break;
            case "readyforpickup":
                maintenanceController.readyForPickup(maintenance);
                break;
            case "pickup":
                maintenanceController.pickup(maintenance);
                break;
        }
    }
}

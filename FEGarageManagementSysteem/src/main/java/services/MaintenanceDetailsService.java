package services;

import entities.Car;
import entities.Maintenance;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Sander on 29-11-2016.
 */
    @Getter
    @Setter
    @Named("maintenanceDetailsService")
    @RequestScoped
public class MaintenanceDetailsService implements  Serializable{

        private Maintenance maintenance;

        private String maintenanceId;

    @EJB
    private IMaintenanceService maintenanceService;

    public void setMaintenance(){
        maintenance = maintenanceService.getOne(Long.parseLong(maintenanceId));
    }
}

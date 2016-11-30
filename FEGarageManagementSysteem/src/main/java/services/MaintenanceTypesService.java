package services;

import entities.MaintenanceType;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 28-11-2016.
 */
@Getter
@Setter
@Named("maintenancetype")
@SessionScoped
public class MaintenanceTypesService implements Serializable {

    private String updateKey;

    private MaintenanceType type;
    @EJB
    private IMaintenanceTypeService maintenanceTypeService;

    public MaintenanceTypesService() {
        type = new MaintenanceType();
    }

    public List<MaintenanceType> all() {
        List<MaintenanceType> all = maintenanceTypeService.getAllTypes();
        return all;
    }

    public void setMaintenanceType() {
        type = maintenanceTypeService.getOneType(Long.parseLong(updateKey));
    }

    public void updateType() {
        maintenanceTypeService.add(type);
    }

    public void clearType() {
        type = new MaintenanceType();
    }
}

package services;

import entities.Customer;
import entities.MaintenanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 28-11-2016.
 */
@Named("maintenancetype")
@SessionScoped
@NoArgsConstructor
@Data
public class MaintenanceTypesService  implements Serializable {

    private String updateKey;

    private MaintenanceType type;

    @EJB
    private IMaintenanceTypeService maintenanceTypeService;

    public List<MaintenanceType> all() {
        List<MaintenanceType> all = maintenanceTypeService.getAllTypes();
        return all;
    }

    public void setMaintenanceType(){
        type = maintenanceTypeService.getOneType(Long.parseLong(updateKey));
    }
    public void updateType() {
        maintenanceTypeService.add(type);
    }
}

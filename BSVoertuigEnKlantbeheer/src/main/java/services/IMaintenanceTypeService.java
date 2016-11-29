package services;

import entities.Maintenance;
import entities.MaintenanceType;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Sander on 28-11-2016.
 */
@Remote
public interface IMaintenanceTypeService {
    List<MaintenanceType> getAllTypes();
    MaintenanceType add(MaintenanceType maintenanceType);
    MaintenanceType getOneType(Long id);
}

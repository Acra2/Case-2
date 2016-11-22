package setup;

import entities.Car;
import entities.Maintenance;
import services.IMaintenanceService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.time.LocalDateTime;

/**
 * Created by Sander on 22-11-2016.
 */
@Singleton
@Startup
public class SetMaintenanceData {
    @EJB
    private IMaintenanceService maintenanceService;

    @PostConstruct
    public void setData() {
        Maintenance maintenance = new Maintenance();
        maintenance.setId(1234L);
        maintenanceService.add(maintenance);
    }
}

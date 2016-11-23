package setup;

import entities.Maintenance;
import entities.Mechanic;
import services.IMaintenanceService;
import services.IMechanicService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Created by Sander on 22-11-2016.
 */
@Singleton
@Startup
public class SetMaintenanceData {

    @EJB
    private IMaintenanceService maintenanceService;

    @EJB
    private IMechanicService mechanicService;

    @PostConstruct
    public void setData() {
        Mechanic henk = Mechanic.builder().Name("henk").build();
        mechanicService.add(henk);

        Maintenance maintenance = new Maintenance();
        maintenance.setMechanic(henk);
        maintenanceService.add(maintenance);
    }
}

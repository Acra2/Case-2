package setup;

import entities.Maintenance;
import entities.Mechanic;
import services.IMaintenanceService;

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

    @PostConstruct
    public void setData() {
        Mechanic mechanic = Mechanic.builder().Name("Henk").build();

        Maintenance maintenance = new Maintenance();
        maintenance.setMechanic(mechanic);
        maintenanceService.add(maintenance);

        Maintenance maintenance2 = new Maintenance();
        maintenance2.setMechanic(mechanic);
        maintenanceService.add(maintenance2);
    }
}

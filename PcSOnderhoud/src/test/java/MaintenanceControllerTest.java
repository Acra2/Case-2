import controllers.MaintenanceController;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.MaintenanceType;
import entities.Mechanic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import rdw.CdiProvider;
import rdw.RDWSteekproefMock;
import services.impl.MaintenanceService;
import services.impl.MechanicService;

import javax.enterprise.inject.spi.CDIProvider;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Created by Sander on 30-11-2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MaintenanceControllerTest {

    @Mock
    MechanicService mechanicService;

    @Mock
    CdiProvider provider;

    @Mock
    RDWSteekproefMock steekproefMock;

    @InjectMocks
    MaintenanceController controller;

    @Test
    public void changeMechanicCorrect(){
        Maintenance maintenance = TestBuilder.maintenance1().build();
        Mechanic mechanic2  = TestBuilder.mechanic2().build();
        when(mechanicService.getMechanic(2L)).thenReturn(mechanic2);
        controller.changeMechanic(maintenance, "2");
        assertThat(maintenance.getMechanic(), is(mechanic2));
    }

    @Test
    public void changeMechanicInCorrectId(){
        Maintenance maintenance = TestBuilder.maintenance1().build();
        Mechanic mechanic1  = TestBuilder.mechanic1().build();
        when(mechanicService.getMechanic(3L)).thenReturn(null);
        controller.changeMechanic(maintenance, "3");
        assertThat(maintenance.getMechanic(), is(mechanic1));
    }

    @Test
    public void finishMaintenanceWithSampleTrue() throws Exception {
        MaintenanceType maintenanceType = TestBuilder.maintenanceType1().build();

        Maintenance maintenance = TestBuilder.maintenance1().state(MaintenanceState.INMAINTENANCE).type(maintenanceType).build();
        when(provider.provide()).thenReturn(steekproefMock);
        when(steekproefMock.steekproef("50-16-AB")).thenReturn(true);
        controller.finish(maintenance);
        String stateString = maintenance.getState().toString();
        assertThat(stateString, is("Wacht op keuring"));
    }

    @Test
    public void finishMaintenanceWithSampleFalse() throws Exception {
        MaintenanceType maintenanceType = TestBuilder.maintenanceType1().build();

        Maintenance maintenance = TestBuilder.maintenance1().state(MaintenanceState.INMAINTENANCE).type(maintenanceType).build();
        when(provider.provide()).thenReturn(steekproefMock);
        when(steekproefMock.steekproef("50-16-AB")).thenReturn(false);
        controller.finish(maintenance);
        String stateString = maintenance.getState().toString();
        assertThat(stateString, is("Klaar voor uitleveren"));
    }

    @Test
    public void finishMaintenanceWithoutSample() throws Exception {
        MaintenanceType maintenanceType = TestBuilder.maintenanceType2().build();

        Maintenance maintenance = TestBuilder.maintenance1().state(MaintenanceState.INMAINTENANCE).type(maintenanceType).build();
        controller.finish(maintenance);
        String stateString = maintenance.getState().toString();
        assertThat(stateString, is("Klaar voor uitleveren"));
    }
}

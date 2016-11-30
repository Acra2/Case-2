import entities.Maintenance;
import entities.MaintenanceState;
import entities.StateException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
/**
 * Created by Sander on 22-11-2016.
 */
public class MaintenanceStateTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void correctProcessWithInspection() throws Exception {
        Maintenance maintenance = TestBuilder.maintenance().build();
        maintenance.present();
        maintenance.start();
        maintenance.pause();
        maintenance.start();
        maintenance.finish();
        maintenance.needInspections();
        maintenance.readyForPickUp();
        assertThat(MaintenanceState.READYFORPICKUP, is(maintenance.getState()));
    }

    @Test
    public void correctProcessWithoutInspection() throws Exception {
        Maintenance maintenance = TestBuilder.maintenance().build();
        maintenance.present();
        maintenance.start();
        maintenance.finish();
        maintenance.readyForPickUp();
        assertThat(MaintenanceState.READYFORPICKUP, is(maintenance.getState()));
    }

    @Test
    public void inCorrectEarlyFinish() throws StateException {
        thrown.expect(StateException.class);
        Maintenance maintenance = TestBuilder.maintenance().build();
        maintenance.present();
        maintenance.finish();
    }

    @Test
    public void inCorrectEarlyPickup() throws StateException {
        thrown.expect(java.lang.Exception.class);
        Maintenance maintenance = TestBuilder.maintenance().build();
        maintenance.present();
        maintenance.readyForPickUp();
    }

    @Test
    public void inCorrectLatePause() throws StateException {
        thrown.expect(StateException.class);
        Maintenance maintenance = TestBuilder.maintenance().build();
        maintenance.present();
        maintenance.start();
        maintenance.finish();
        maintenance.pause();
    }
}

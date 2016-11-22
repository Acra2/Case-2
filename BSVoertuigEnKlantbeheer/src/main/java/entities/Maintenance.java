package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Sander on 22-11-2016.
 */
@Data
@Entity(name = "maintenance")
@NamedQuery(name = "getAllMaintenance", query = "SELECT m from maintenance m")
@Builder
@AllArgsConstructor
public class Maintenance implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Car car;

    private LocalDateTime startDateTime;

    @Enumerated(EnumType.STRING)
    private MaintenanceState state = MaintenanceState.PLANNED;

    private String description;

    public Maintenance() {
    }

    public void present() throws StateException {
        state.present(this);
    }

    public void start() throws StateException {
        state.startMaintenace(this);
    }

    public void pause() throws StateException {
        state.pauseMaintenace(this);
    }

    public void finish() throws StateException {
        state.finishMaintenace(this);
    }

    public void needInspections() throws StateException {
        state.needInspections(this);
    }

    public void readyForPickUp() throws StateException {
        state.readyForPickUp(this);
    }
}

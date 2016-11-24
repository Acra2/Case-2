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
@NamedQueries({@NamedQuery(name = "getAllMaintenance", query = "SELECT m from maintenance m"),
        @NamedQuery(name = "getMaintenanceForMechanicAndState", query = "SELECT m from maintenance m WHERE m.mechanic.id = :mechanicId and m.state = entities.MaintenanceState.INMAINTENANCE")})
@Builder
@AllArgsConstructor
public class Maintenance implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id;
    private LocalDateTime startDateTime;
    private String description;

    @Enumerated(EnumType.STRING)
    private MaintenanceState state = MaintenanceState.PLANNED;

    @Enumerated(EnumType.STRING)
    private MaintenanceType type;

    @ManyToOne
    private Car car;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn
    private Mechanic mechanic;

    public Maintenance() {
    }

    public void present() {
        try {
            state.present(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            state.startMaintenace(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        try {
            state.pauseMaintenace(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void finish(){
        try {
            state.finishMaintenace(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void needInspections() {
        try {
            state.needInspections(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }

    public void readyForPickUp(){
        try {
            state.readyForPickUp(this);
        } catch (StateException e) {
            e.printStackTrace();
        }
    }
}

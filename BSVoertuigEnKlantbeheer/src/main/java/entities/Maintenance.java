package entities;

import interceptors.LogInterceptorBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Sander on 22-11-2016.
 */
@Data
@Entity(name = "maintenance")
@NamedQueries({
        @NamedQuery(name = "getAllMaintenance", query = "SELECT m from maintenance m"),
        @NamedQuery(name = "getMaintenanceForMechanicAndState", query = "SELECT m from maintenance m WHERE m.mechanic.id = :mechanicId and m.state = entities.MaintenanceState.INMAINTENANCE"),
        @NamedQuery(name = "getMaintenanceForCar", query = "SELECT m from maintenance m WHERE m.car.vehicleNumber = :vehiclenumber"),
        @NamedQuery(name = "CarsInMaintenance", query = "SELECT  m from maintenance m where m.state = entities.MaintenanceState.INMAINTENANCE or m.state = entities.MaintenanceState.PAUSED or m.state = entities.MaintenanceState.READYFORSAMPLE")
})
@Builder
@AllArgsConstructor
@LogInterceptorBinding
@SequenceGenerator(name = "seq", initialValue = 100000, allocationSize = 1)
public class Maintenance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;
    private LocalDateTime startDateTime;
    private String description;

    @Enumerated(EnumType.STRING)
    private MaintenanceState state = MaintenanceState.PLANNED;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private MaintenanceType type;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Mechanic mechanic;

    public Maintenance() {
    }

    public void present() throws StateException {
        try {
            state.present(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void start() throws StateException {
        try {
            state.startMaintenace(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void pause() throws StateException {
        try {
            state.pauseMaintenace(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void finish() throws StateException {
        try {
            state.finishMaintenace(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void needInspections() throws StateException {
        try {
            state.needInspections(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void readyForPickUp() throws StateException {
        try {
            state.readyForPickUp(this);
        } catch (StateException e) {
            throw e;
        }
    }

    public void pickUp() throws StateException {
        try {
            state.pickedUp(this);
        } catch (StateException e) {
            throw e;
        }
    }
}

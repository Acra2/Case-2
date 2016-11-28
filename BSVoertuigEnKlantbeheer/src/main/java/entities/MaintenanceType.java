package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sander on 24-11-2016.
 */
@Builder
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "getAllMaintenanceTypes", query = "SELECT m from maintenancetype m"),
})
@Entity(name = "maintenancetype")
@Data
public class MaintenanceType implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int time;
    private String tasks;
    private double price;

    public MaintenanceType() {
    }
}

package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */


@Builder
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT c from car c"),
        @NamedQuery(name = "getOneCar", query = "SELECT c from car c where c.vehicleNumber = :vehicleNumber"),
        @NamedQuery(name = "update", query = "UPDATE car  c " +
                "SET " +
                "c.driverEmail = :mail," +
                "c.driverName = :name, " +
                "c.driverPhoneNumber = :phonenumber, " +
                "c.licensePlate = :licenseplate, " +
                "c.mileage = :mileage " +
                "WHERE c.vehicleNumber = :vehicleNumber"),
        @NamedQuery(name = "getCarsOfSpecificCustomer", query = "SELECT c FROM car c WHERE c.customer = :customer")
})
@Entity(name = "car")
@Data
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleNumber;
    private String licensePlate;
    private Integer mileage;
    private String driverName;
    private String driverEmail;
    private String driverPhoneNumber;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Model model;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn
    private Customer customer;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Maintenance> maintenanceList;

    public Car() {
    }
}

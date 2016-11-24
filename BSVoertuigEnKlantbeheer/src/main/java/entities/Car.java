package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT c from car c"),
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
public class Car implements Serializable {

    @Id
    private String vehicleNumber;
    private String licensePlate;
    private Integer mileage;
    private String driverName;
    private String driverEmail;
    private String driverPhoneNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Model model;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Customer customer;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenanceList;

}

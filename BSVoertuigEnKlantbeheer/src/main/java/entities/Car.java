package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
@Entity(name = "car")
@Data
@NamedQueries({
        @NamedQuery(name = "getAll", query = "SELECT c from car c"),
        @NamedQuery(name = "update", query = "UPDATE car  c " +
                "SET " +
                "c.driverEmail = :mail," +
                "c.driverName = :name, " +
                "c.driverPhoneNumber = :phonenumber, " +
                "c.licensePlate = :licenseplate, " +
                "c.mileage = :mileage, " +
                "c.customer = :customer " +
                "WHERE c.vehicleNumber = :vehicleNumber")
})

@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenanceList;


}

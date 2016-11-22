package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.interceptor.Interceptor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    private String vehiclenumber;
    private String licenseplate;
    private Integer mileage;
    private String driverName;
    private String driverEmail;
    private String driverPhonenumber;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Maintenance> maintenanceList;
}

package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kai on 22-11-2016.
 */

@Getter
@Setter
@Entity(name = "customer")
@Builder
@NamedQueries({
        @NamedQuery(name = "getAllCustomers", query = "SELECT c from customer c"),
        @NamedQuery(name = "updateCustomer", query = "UPDATE customer c " +
                "SET " +
                "c.adress = :adress," +
                "c.btwnumber = :btwnumber, " +
                "c.email = :email, " +
                "c.name = :name, " +
                "c.phonenumber = :phonenumber " +
                "WHERE c.id = :id") ,
        @NamedQuery(name = "getCustomerByEmail", query = "SELECT c FROM customer  c WHERE c.email = :email")
})
@AllArgsConstructor
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String adress;
    private String phonenumber;
    private String btwnumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Car> cars;

    public Customer() {
    }
}

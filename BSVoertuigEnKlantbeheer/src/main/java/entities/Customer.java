package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */


@Entity(name = "customer")
@Builder
@Data
@AllArgsConstructor
public class Customer implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    private String name;
    private String email;
    private String adress;
    private String phonenumber;
    private String btwnumber;

    @OneToMany
    private List<Car> cars;

    public Customer() {
    }
}

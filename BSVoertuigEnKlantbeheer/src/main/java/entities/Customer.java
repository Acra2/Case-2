package entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    private String Name;
    private String email;
    private String adress;
    private String phonenumber;
    private String btwnumber;

    @OneToMany
    private List<Car> cars;
}

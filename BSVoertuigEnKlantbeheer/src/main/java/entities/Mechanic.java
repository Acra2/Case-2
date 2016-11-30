package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Sander on 23-11-2016.
 */
@Entity(name = "mechanic")
@Data
@Builder
@NamedQueries({
        @NamedQuery(name = "getAllMechanics", query = "SELECT m from mechanic m")})
@AllArgsConstructor
public class Mechanic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String Name;

    @OneToMany(mappedBy = "mechanic")
    private List<Maintenance> maintenance;

    public Mechanic() {
    }
}

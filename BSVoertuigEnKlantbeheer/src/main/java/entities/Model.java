package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sander on 23-11-2016.
 */
@Entity(name = "model")
@Builder
@Data
@AllArgsConstructor
@NamedQuery(name = "getAllModels", query = "SELECT m from model m")
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Brand brand;

    public Model() {
    }
}
